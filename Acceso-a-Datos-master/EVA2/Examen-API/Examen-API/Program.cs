using Examen_API.Models;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();

builder.Services.AddDbContext<DataContext>(options => {
  options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection"));
});

builder.Services.AddCors(o => o.AddPolicy("AllowAnyCorsPolicy", builder => {
  builder.AllowAnyOrigin()
    .AllowAnyMethod()
    .AllowAnyHeader();
}));

builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment()) {
  app.UseSwagger();
  app.UseSwaggerUI();
  app.UseCors("AllowAnyCorsPolicy");
}

app.UseAuthorization();

app.MapControllers();

app.Run();
