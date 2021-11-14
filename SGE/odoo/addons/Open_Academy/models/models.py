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