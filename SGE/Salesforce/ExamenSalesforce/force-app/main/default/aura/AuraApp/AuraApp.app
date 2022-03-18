<aura:application controller="RandomNumber">
  <button onclick="{!c.jugar}">Generar numero</button>
  <c:CartonComponent></c:CartonComponent>

  <aura:registerEvent name="SacarBolaEvent" type="c:SacarBolaEvent"/>
</aura:application>
