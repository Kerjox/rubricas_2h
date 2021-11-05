from odoo import fields, models, api

class Course(models.Model):
    _name = 'aca.course'
    name = fields.Char('Name')
    description = fields.Text('Description')