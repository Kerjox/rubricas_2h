import { LightningElement, track } from 'lwc';
import addTodo from "@salesforce/apex/ToDoController.addTodo";
export default class ToDoManager extends LightningElement {

  @track time = "9:00 PM";
  @track greeting = "Good Evening";
  @track todos = [];

  connectedCallback() {

    this.getTime();
    this.populateTodos();

    setInterval(() => {
      this.getTime();
      console.log("Set interval called");
    }, 1000*60);
  }

  getTime() {

    const date = new Date();
    const hours = date.getHours();
    const minutes = date.getMinutes();

    this.time = this.getDoubleDigit(this.getHour(hours)) + ":" + this.getDoubleDigit(minutes) + " " + this.getMidDay(hours);
    
    this.setGreeting(hours);
  }

  getHour(hour) {
    return hour === 0 ? 12 : hour > 12 ? hour - 12 : hour;
  }

  getMidDay(hour) {
    return hour < 12 ? "AM" : "PM";
  }

  getDoubleDigit(digit) {
    return digit < 10 ? "0" + digit : digit;
  }

  setGreeting(hour) {

    if (hour < 12) {
      this.greeting = "Good Morning";
    } else if (hour >= 12 && hour < 17) {
      this.greeting = "Good Afternoon";
    } else {
      this.greeting = "Good Evening";
    }
  }

  addTodoHandler() {

    const inputBox = this.template.querySelector("lightning-input");
    
    const todo = {
      todoName: inputBox.value,
      done: false
    }
    
    addTodo({ payload: JSON.stringify(todo) }).then(result => {

      console.log("Item added successfully");
    }).catch(error => {

      console.error("Item not inserted" + error);
    });
    //this.todos.push(todo);
    inputBox.value = "";
  }

  get upcomingTasks() {

    return this.todos && this.todos.length 
    ? this.todos.filter(todo => !todo.done) 
    : [];
  }

  get completedTasks() {
  
    return this.todos && this.todos.length 
    ? this.todos.filter(todo => todo.done) 
    : [];
  }

  populateTodos() {

    const todos = [
      {
        todoId: 0,
        todoName: "Feed the dog",
        done: false,
        todoDate: new Date()
      },
      {
        todoId: 1,
        todoName: "Wash the car",
        done: false,
        todoDate: new Date()
      },
      {
        todoId: 2,
        todoName: "Send email",
        done: true,
        todoDate: new Date()
      }
  ];

  this.todos = todos;
  }
}