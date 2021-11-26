from odoo import fields, models, api
from odoo.exceptions import ValidationError

class Persona(models.Model):
    _name = 'examen.persona'
    name = fields.Char('Nombre')
    direction = fields.Char('Direccion')
    telefono = fields.Char('Telefono')


class Estudiante(models.Model):
    _inherit = 'examen.persona'
    _name = 'examen.estudiante'
    portatiles_id = fields.One2many('examen.portatil', 'comprador_id', string='Portatiles')

class Portatil(models.Model):
    _name = 'examen.portatil'
    name = fields.Char('Modelo')
    marca = fields.Char('Marca')
    cpu = fields.Char('CPU')
    ram_id = fields.One2many('examen.ram', 'portatil_id', string='RAM')
    hdd_id = fields.One2many('examen.hdd', 'portatil_id', string='HDD')
    fecha_compra = fields.Date('Fecha de Compra')
    usage = fields.Float('Usage')
    comprador_id = fields.Many2one('examen.comprador', string='Comprador')
    precio = fields.Float('Precio')
    observaciones = fields.Text('Observaciones')
    total_ram = fields.Float('Total RAM', compute='_totalram') #Campo calculado
    total_hdd = fields.Float('Total HDD', compute='_totalhdd') #Campo calculado
    ofertas_id = fields.One2many('examen.oferta', 'portatil_id', string='Oferta')
    vendido = fields.Boolean('Vendido', compute='_vendido') #Campo calculado

    @api.depends('ram_id')
    def _totalram(self):
        for record in self:
            if len(record.ram_id) != 0:
                if len(record.ram_id) > 1:
                    for ram in record.ram_id:
                        record.total_ram += ram.cantidad
                else:

                    record.total_ram = record.ram_id.cantidad
            else:
                record.total_ram = 0.0

    @api.depends('hdd_id')
    def _totalhdd(self):
        for record in self:
            if len(record.hdd_id) != 0:
                if len(record.hdd_id) > 1:
                    for hdd in record.hdd_id:
                        record.total_hdd += hdd.capacidad

                else:
                    record.total_hdd = record.hdd_id.capacidad
            else:
                record.total_hdd = 0.0

    @api.depends('ofertas_id')
    def _vendido(self):
        for record in self:
            if len(record.ofertas_id) != 0:
                if record.ofertas_id.aceptada:
                    record.vendido = True
                else:
                    record.vendido = False
            else:
                record.vendido = False

class RAM(models.Model):
    _name = 'examen.ram'
    name = fields.Char('Nombre')
    frecuencia = fields.Integer('Frecuencia')
    latencia = fields.Char('Latencia')
    cantidad = fields.Integer('Cantidad GB')
    tipo = fields.Selection([('DDR', 'DDR'), ('DDR2', 'DDR2'), ('DDR3', 'DDR3')], string='Tipo')
    portatil_id = fields.Many2one('examen.portatil', string='Portatil')


class HDD(models.Model):
    _name = 'examen.hdd'
    name = fields.Char('Nombre')
    capacidad = fields.Integer('Capacidad')
    tipo = fields.Selection([('SSD', 'SSD'), ('HDD', 'HDD')], string='Tipo')
    portatil_id = fields.Many2one('examen.portatil', string='Portatil')


class Comprador(models.Model):
    _inherit = 'examen.persona'
    _name = 'examen.comprador'
    portatiles_id = fields.One2many('examen.portatil', 'comprador_id', string='Portatiles')
    ofertas_id = fields.One2many('examen.oferta', 'comprador_id', string='Ofertas')


class Oferta(models.Model):
    _name = 'examen.oferta'
    name = fields.Char('Nombre')
    portatil_id = fields.Many2one('examen.portatil', string='Portatil')
    aceptada = fields.Boolean('Aceptada')
    comprador_id = fields.Many2one('examen.comprador', string='Comprador')
    observaciones = fields.Text('Observaciones')