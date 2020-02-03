ejercicio 1

/productos/produc/denominacion | /productos/produc/precio

/productos/produc[contains(denominacion,"Placa Base")]

/productos/produc[pecio>60 and cod_zona=20]

count(productos/produc[contains(denominacion,"Memoria") and cod_zona=10])

avg(/productos/produc[contains(denominacion,"Micro")]/precio)

/productos/produc[number(stock_minimo)>number(stock_actual)]

/productos/produc[number(stock_minimo)>number(stock_actual) and cod_zona=40]/concat(nombre," ",producto," ",precio)

/productos/produc[stock_actual<stock_minimo and cod_zona=40]/text()

/productos/produc[precio=max(precio)]

/productos/produc[cod_zona=20 and precio=min(productos/produc[cod_zona=20]/precio) ]

/productos/produc[cod_zona=10 and precio=max(productos/produc[cod_zona=10]/precio) ]


ejercicio2

1. /sucursales/sucursal/cuenta[@tipo="AHORRO"]

2. /sucursales/sucursal/concat(@codigo,"-",count(cuenta[@tipo="AHORRO"]))

3. /sucursales/sucursal[@codigo="SUC3"]/cuenta[@tipo="PENSIONES" ]

4. /sucursales/sucursal/concat(@codigo," ",director," ",sum(cuenta/saldohaber))

5. 

5. /sucursales/sucursal[count(cuenta)>3]


6. /sucursales/sucursal[count(cuenta)>3 and  cuenta[@tipo="AHORRO"]]

7. /sucursales/sucursal[count(cuenta)>3]/concat(director," ",poblacion)

8. /sucursales/count(sucursal[poblacion="Madrid"])

9. /sucursales/sucursal/concat(@codigo," ",sum(cuenta[@tipo="PENSIONES"]/aportacion))

10. /sucursales/sucursal/cuenta[saldohaber>10000]/concat(nombre," ",numero," ",saldohaber)

11. /sucursales/sucursal[count(cuenta)>3 and  cuenta[@tipo="AHORRO"]]/concat(@codigo," ",sum(cuenta[@tipo="AHORRO"]/saldodebe))


ejercicio3

1. for $zone in distinct-values(/productos/produc/cod_zona)
let $numero := count(/productos/produc[cod_zona = $zone]/cod_prod)
return concat('Zona: ',$zone,' Cantidad: ',$numero)

2.
for $z in distinct-values(/productos/produc/cod_zona)
let $p:=/productos/produc
return
if($z=10)
then
<zona10>{'Productos: ',$p[cod_zona=number($z)]/denominacion/text(),', '}</zona10>
else if($z=20)
then
<zona20>{'Productos: ',$p[cod_zona=number($z)]/denominacion/text(),' '}</zona20>
else if($z=30)
then
<zona30>{'Productos: ',$p[cod_zona=number($z)]/denominacion/text(),' '}</zona30>
else if($z=40)
then
<zona40>{'Productos: ',$p[cod_zona=number($z)]/denominacion/text(),', '}</zona40>
else()

3.
for $z in distinct-values(/productos/produc/cod_zona)
let $p:=/productos/produc[cod_zona=$z and precio=max(/productos/produc[cod_zona=$z]/precio)]/denominacion
return $p

4.
for $pr in /productos/produc
return
if($pr[contains(denominacion,'Placa')])
then
<placa>{$pr[contains(denominacion,'Placa')]/denominacion/text(),' '}</placa>

else if($pr[contains(denominacion,'Memoria')])
then
<memoria>{$pr[contains(denominacion,'Memoria')]/denominacion/text(),' '}</memoria>


else if($pr[contains(denominacion,'Micro')])
then
<micro>{$pr[contains(denominacion,'Micro')]/denominacion/text(),' '}</micro>

else if($pr[not(contains(denominacion,'Memoria') and contains(denominacion,'Micro') and contains(denominacion,'Placa')  )])
then
<otros>{$pr[not(contains(denominacion,'Memoria') and contains(denominacion,'Micro') and contains(denominacion,'Placa')  )]/denominacion/text(),' '}</otros>

else()


5.
for $sucu in /sucursales/sucursal
let $codigo :=$sucu[@codigo]/concat('codigo sucursal : ',@codigo)
let $numero := count($sucu/cuenta[@tipo='AHORRO'])
let $numero2 := count($sucu/cuenta[@tipo='PENSIONES'])
return concat($codigo,' Cuentas tipo ahorro: ',$numero,' Cuentas tipo pensiones: ',$numero2)

6.
for $sucu in /sucursales/sucursal
let $codigo :=$sucu[@codigo]/concat('codigo sucursal : ',@codigo,' Director: ',director,' Poblacion: ',poblacion,' Total saldo debe:',sum(cuenta/saldodebe),' Total saldo haber:',sum(cuenta/saldohaber) )
return $codigo

7.

for $sucu in /sucursales/sucursal[@codigo]
let $res :=$sucu/concat('codigo sucursal : ',@codigo,' Director: ',director,' Poblacion: ',poblacion,' Total saldo debe:',sum(cuenta/saldodebe),' Total saldo haber:',sum(cuenta/saldohaber) )
return if(count($sucu/cuenta)>3)
then
<datos>{data($res)} </datos>
else()

8.
for $sucu in  /sucursales/sucursal[@codigo]
let $res :=$sucu/concat('codigo sucursal : ',@codigo,' Total saldo debe:',max(cuenta/saldodebe) )
return $res

9.
for $sucu in  /sucursales/sucursal/cuenta
let $res :=$sucu[@tipo='PENSIONES' and aportacion=max(/sucursales/sucursal/cuenta/aportacion)]
return $res

ejercicio 4

1.
for $prod in /productos/produc 
order by $prod/cod_zona
let $den:= $prod/denominacion
let $precio:= $prod/precio
let $zona:= $prod/cod_zona
let $zonab:=(/zonas/zona[cod_zona=$zona]/nombre)
return <re>{$den,$precio,$zonab}  </re>



for $prod in /zonas/zona
order by $prod/nombre
let $name:=$prod/nombre
let $den:= (/productos/produc[cod_zona=$prod/cod_zona]/denominacion)
let $precio:= (/productos/produc[cod_zona=$prod/cod_zona]/precio)

return <producto>
<denominacion>{data($den)} </denominacion>  
<precio>{data($precio)} </precio>  
<nombre>{data($name)}</nombre>  
</producto>

2.
for $prod in /zonas/zona
order by $prod/nombre
let $name:=$prod/nombre
let $den:= (count(/productos/produc[cod_zona=$prod/cod_zona]))


return 
<zona>
<nombre>{data($name)}</nombre> 
<productos>{data($den)} </productos>  
</zona>


3.
for $zone in /zonas/zona

let $name:=$zone/nombre
let $cod:=$zone/cod_zona
let $den:= (/productos/produc[cod_zona=$zone/cod_zona and stock_actual=min(stock_actual)]/denominacion)


return 
<zona>
<nombre>{data($name)}</nombre> 
<codigo_zona>{data($cod)}</codigo_zona>
<productos>{data($den)}</productos>  
</zona>
ejercicio 5

1.
for $sucu in /sucursales/sucursal
let $codigo :=$sucu[@codigo]/cuenta[saldohaber=max(saldohaber)]/concat('nombre: ',nombre,' saldohaber: ',saldohaber)
return	 $codigo

2.
