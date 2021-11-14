from odoo import fields, models, api

class Course(models.Model):
    _name = 'aca.courses'
    name = fields.Char('Name')
    description = fields.Text('Description')
    session_id = fields.One2many('aca.sessions', 'course_id', string='Session')

class Session(models.Model):
    _name = 'aca.sessions'
    name = fields.Char('Name')
    start_date = fields.Date('Start Date')
    duration = fields.Integer('Duration')
    seats = fields.Integer('Seats')
    course_id = fields.Many2one('aca.courses', string='Course')
    user_id = fields.Many2one('aca.users', string='Responsable User')
    instructor_id = fields.Many2one('aca.instructors', string='Instructor')
    attendees_ids = fields.Many2many('aca.attendees', 'session_attendees_PK', 'attendees_id', 'session_id', string='Asistants')

class User(models.Model):
    _name = 'aca.users'
    name = fields.Char('Name')
    session_id = fields.One2many('aca.sessions', 'user_id', string='Session')


class Instructor(models.Model):
    _name = 'aca.instructors'
    name = fields.Char('Name')
    session_id = fields.One2many('aca.sessions', 'instructor_id', string='Session')

class Attendees(models.Model):
    _name = 'aca.attendees'
    name = fields.Char('Name')
    session_ids = fields.Many2many('aca.sessions', 'session_attendees_PK', 'session_id', 'attendees_id', string='Session')