import random
from odoo import fields, models, api
from odoo.exceptions import ValidationError


class User(models.Model):
    _name = 'ksi.users'
    name = fields.Char('Nombre')
    age = fields.Integer('Edad')
    ship_id = fields.One2many('ksi.ships', 'user_id', string='Nave')

    # Validation Error
    @api.constrains('age')
    def _check_something(self):
        for record in self:
            if record.age > 100:
                raise ValidationError("OMG: %s years WTF!" % record.age)
    # all records passed the test, don't return anything
class Ships(models.Model):
    _name = 'ksi.ships'
    name = fields.Char('Nombre')
    model = fields.Char('Modelo')
    manufacturer = fields.Char('Fabricante')
    manufacture_date = fields.Date('Fecha fabricacion')
    space_cargo_slot = fields.Integer('Space cargo per slot', default='1')
    cargo_slots = fields.Integer('Number slots', default='1')
    cargo_space = fields.Integer('Cargo space')

    # onchange handler
    @api.onchange('space_cargo_slot', 'cargo_slots')
    def _onchange_price(self):
    # set auto-changing field
        self.cargo_space = self.cargo_slots * self.space_cargo_slot
        # Can optionally return a warning and domains
        if (self.cargo_slots == 0 or self.space_cargo_slot == 0):

            return {
                'warning': {
                    'title': "Unexpected values",
                    'message': "Cero detected",
                }
        }

    # SQL constrain
    _sql_constraints = [ ('name',
                            'UNIQUE (name)',
                            'El nombre no se puede duplicar'), ]

class ConcesionariosShips(models.Model):
    _inherit = 'ksi.ships'
    stock = fields.Integer('Cantodad')
    concesionario_id = fields.Many2one('ksi.concesionarios', string='Concesionario')

class UserShips(models.Model):
    _inherit = 'ksi.ships'
    user_id = fields.Many2one('ksi.users', string='Usuario')


class Concesionarios(models.Model):
    _name = 'ksi.concesionarios'
    _description = 'Concesionarios'
    name = fields.Char('Nombre', required=True)
    ships_id = fields.One2many('ksi.ships', 'concesionario_id', string='Naves')
    spaceport_id = fields.Many2one('ksi.space.ports', string='Space Port')


class SpacePorts(models.Model):
    _name = 'ksi.space.ports'
    _description = 'Puertos espaciales'
    name = fields.Char('Nombre', required=True)
    orbita = fields.Integer('Orbita', compute='_orbita')
    concesionarios_id = fields.One2many('ksi.concesionarios', 'spaceport_id', string='Concesionarios')
    planet_id = fields.Many2one('ksi.planets', string='Planeta')

    def _orbita(selft):
        for record in selft:
            record.orbita = int(random.randint(1, 10))


class Planets(models.Model):
    _name = 'ksi.planets'
    _description = 'Planetas registrados'
    name = fields.Char('Nombre', required=True)
    spaceports_id = fields.One2many('ksi.space.ports', 'planet_id', string='Space ports')
    system_id = fields.Many2one('ksi.systems', string='Sistema')


class Systems(models.Model):
    _name = 'ksi.systems'
    _description = 'Sistemas planetarios'
    name = fields.Char('Nombre', required=True)
    type = fields.Selection([('1', 'Comercio'), ('2', 'Minero'), ('3', 'Colonialista')], 'Tipo')
    planets_id = fields.One2many('ksi.planets', 'system_id', string='Planetas')