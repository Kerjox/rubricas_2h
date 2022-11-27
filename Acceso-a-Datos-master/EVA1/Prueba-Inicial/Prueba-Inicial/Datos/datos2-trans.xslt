<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
	<xsl:template match="Datos">
		<Datos>
			<xsl:apply-templates></xsl:apply-templates>
		</Datos>
	</xsl:template>

	<xsl:template match="Persona">
		<Data>
			<xsl:for-each select="*">
				<xsl:attribute name="{name()}">
					<xsl:value-of select="text()"/>
				</xsl:attribute>
			</xsl:for-each>
		</Data>
	</xsl:template>
	
</xsl:stylesheet>
