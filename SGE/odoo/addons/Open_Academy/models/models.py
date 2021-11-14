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
    partner_ids = fields.Many2many('aca.partners', 'session_partner_PK', 'partner_id', 'session_id', string='Partners')

class User(models.Model):
    _name = 'aca.users'
    name = fields.Char('Name')
    session_id = fields.One2many('aca.sessions', 'user_id', string='Session')


class Partner(models.Model):
    _name = 'aca.partners'
    name = fields.Char('Name')
    session_ids = fields.Many2many('aca.sessions', 'session_partner_PK', 'session_id', 'partner_id', string='Sessions')


class Instructor(models.Model):
    _inherit = 'aca.partners'
    instructor = fields.Boolean('Instructor')
