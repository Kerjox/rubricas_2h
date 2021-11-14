from odoo import fields, models, api

class Course(models.Model):
    _name = 'aca.courses'
    name = fields.Char('Name')
    description = fields.Text('Description')

class Session(models.Model):
    _name = 'aca.sessions'
    name = fields.Char('Name')
    start_date = fields.Date('Start Date')
    duration = fields.Integer('Duration')
    seats = fields.Integer('Seats')