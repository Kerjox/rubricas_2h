from odoo import fields, models, api

class Course(models.Model):
    _name = 'aca.courses'
    name = fields.Char('Name')
    description = fields.Text('Description')