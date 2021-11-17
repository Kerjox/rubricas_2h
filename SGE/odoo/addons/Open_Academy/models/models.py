from odoo import fields, models, api
from odoo.exceptions import ValidationError

class Course(models.Model):
    _name = 'aca.courses'
    name = fields.Char('Name')
    description = fields.Text('Description')
    session_id = fields.One2many('aca.sessions', 'course_id', string='Session')

    @api.constrains('name', description)
    def _check_something(self):
        for record in self:
            if record.name == record.description:
                raise ValidationError("The name must be different than description")

class Session(models.Model):
    _name = 'aca.sessions'
    name = fields.Char('Name')
    start_date = fields.Date('Start Date', default=fields.Date.today())
    active = fields.Boolean('Active', default=True)
    duration = fields.Integer('Duration', default=1)
    seats_available = fields.Integer('Seats')
    percentage_seats = fields.Float('Percentage seats', compute='_compute_percentage')
    course_id = fields.Many2one('aca.courses', string='Course')
    user_id = fields.Many2one('aca.users', string='Responsable User')
    partner_ids = fields.Many2many('aca.partners', 'session_partner_pk', 'partners_id', 'sessions_id', string='Asistentes')

    @api.depends('seats_available', 'partner_ids')
    def _compute_percentage(self):
        for record in self:

            if len(record.partner_ids) <= 0 or record.seats_available <= 0:
                record.percentage_seats = 0.0
            else:
                record.percentage_seats = len(record.partner_ids) / record.seats_available * 100


    @api.onchange('duration')
    def _onchange_duration(self):
        if self.duration <= 0 :
            return {
                'warning': {
                    'title': "Duration",
                    'message': "The duration is invalid",
                }
        }
    
    @api.onchange('seats_available')
    def _onchange_seats_available(self):
        if self.seats_available <= 0 :
            return {
                'warning': {
                    'title': "Seats Available",
                    'message': "The number of seats is invalid",
                }
        }

class User(models.Model):
    _name = 'aca.users'
    name = fields.Char('Name')
    session_id = fields.One2many('aca.sessions', 'user_id', string='Session')


class Partner(models.Model):
    _name = 'aca.partners'
    name = fields.Char('Name')
    session_ids = fields.Many2many('aca.sessions', 'session_partner_pk', 'sessions_id', 'partners_id', string='Sesiones')


class Instructor(models.Model):
    _inherit = 'aca.partners'
    instructor = fields.Boolean('Instructor')
