# PROYECTO MODULO DELIVERY - PLAN 111MIL

## Índice

* [Introducción](#introduccion)
* [Desarrollo](#desarrollo)
* [Limite](#limite)
* [Propiedades del sistema](#propiedades-del-sistema)
* [Arquitectura de Software](#arquitectura-de-software)
* [Tecnologias Aplicadas](#tecnologias-aplicadas)
* [Diagrama de Entidad-Relación (DER)](#diagrama-de-entidad-relacion-der)
* [Diagrama de Clases (UML)](#diagrama-de-clases-uml)
* [Historial de revisiones](#historial-de-revisiones)

## Introducción

En el siguiente documento se desarrolla las características esenciales de un sistema de información correspondiente al dominio de Caso Práctico Nº2 - Pizzeria en el marco del Plan111. 

Estas características comprenden la definición de los objetivos, límites, alcances del sistema, los procesos que se llevan a cabo dentro del mismo, su arquitectura de software, tecnologías aplicadas en el desarrollo, definición de la estructuras de la base de datos a través del diagrama de entidad-relación y la diagramación del modelo del sistema en lenguaje de modelado unificado (UML).
Para la obtención de datos necesarios se utilizó el dominio de negocio aportado por el Plan111 como base añadiendo el proceso de Delivery.

A continuación se detalla el enunciado para conocer el dominio con el cual se trabajara

Una pizzería de la ciudad ofrece a sus clientes una amplia variedad de pizzas de fabricación propia, de varios tamaños (8, 10 y 12 porciones). Los clientes tienen a disposición un menú que describe para cada una de las variedades, el nombre, los ingredientes y el precio según el tamaño y el tipo (a la piedra, a la parrilla, de molde) de la pizza. Los clientes realizan sus pedidos en el mostrador.

El pedido debe contener el nombre del Cliente, para llamarlo cuando su pedido está listo; la cantidad de pizzas, el tamaño, la variedad, la fecha del pedido, la hora en la que el pedido debe entregarse y la demora estimada informada al cliente.

El pedido va a la cocina y cuando está preparado se informa al que lo tomó para que se genere la factura correspondiente y se le entregue el pedido al cliente.

El dueño de la pizzería ha manifestado la necesidad de acceder al menos a la siguiente información:

* Variedades y tipos de pizzas más pedidas por los clientes.
* Ingresos (recaudaciones) por períodos de tiempo.
* Pedidos (cantidad y monto) por períodos de tiempo.

## Desarrollo

### Procesos que se llevan a cabo

El sistema prestará soporte a los siguientes procesos que se llevan a cabo dentro de la organización:

* Pedido: Cada pedido es generado por el cliente cuando éste los solicita teniendo a disposición un menú que describe para cada uno la variedad, nombre, ingredientes, precio y tipo de pizza que desee. Luego de que el cliente realiza la elección se despacha el pedido hacia la cocina, previamente registrado cliente, menues elegidos y fecha. Además se notifica al cliente la demora estimada del pedido.

* Confección de Menú: La confección del menú para ofrecer a los clientes se establecen en base al tipo de pizza, la variedad y tamaño de la misma.

* Envíos a domicilio (Delivery): En el supuesto que el cliente que se le entregue el pedido a domicilio, se le solicite que aporte su domicilio y número de teléfono para realizar la entrega. Se deberá tener en cuenta que el personal de entrega podrá llevar más de un pedido por viaje.

## Límite

### El límite de este sistema es:

Desde la confección de menúes y pedido realizado por el cliente, hasta la emisión de reportes con la información de las recaudaciones, variedades y tipos de pizzas más solicitados y pedidos solicitados, junto con las zonas o barrios donde se realizan más entregas y tiempos de entregas.

## Propiedades del sistema.

### Objetivos: 

Brindar soporte en la gestión de los pedidos de la Pizzería. Proveer información de los procesos que abarca.

### Alcances

* Atender la consulta del cliente (telefónica o personal).

* Buscar el/los menúes que el cliente solicita que serán entregados por el empleado.

* Si el cliente está dentro del local, el empleado deberá mostrar y/o entregar el/los menúes al cliente.

* Gestionar el pedido.

* Una vez que el pedido está listo para entregar y si el pedido fue solicitado con entrega a domicilio, asignar el pedido a PersonaldeEntrega para que se realice la entrega.

* El costo del envío se calcula a partir del punto del comercio (pizeria) hasta el punto de entrega del cliente (domicilio).

* Realizar controles para saber si el Personal de Entrega está disponible.

* Registrar los menúes que se ofrecen a los clientes.

* Realizar reportes con la información solicitada por el dueño de la organización.

* Registrar datos del Personal de Entrega junto con sus vehículos.

* Registrar datos del cliente (se usará el teléfono como identificación principal), con domicilio detallando ciudad, barrio, calle y altura.

* El sistema deberá ofrecer una hoja de ruta recomendada para entregarle o sugerirle al Personal de entrega y así optimizar tiempo y calidad de servicio.

## Arquitectura de Software
Se define una arquitectura cliente-servidor desktop – arquitectura en capas.

### Aplicación:
Se utiliza el patrón para organizar la implementación de este sistema complejo en capas de servicios autocontenidas, para lograr un sistema mantenible, de bajo acoplamiento, adaptable y escalable.

* Capa de presentación: `Vista Desktop`

* Capa de Lógica de Negocios: `Controladores`

* Capa de persistencia: `ORM - Hibernate`

### Motivaciones:

Reutilización de servicios brindados por la interfaz brindada por cada capa. Mejorar la portabilidad. Los cambios de hardware, del sistema operativo y todo lo que afecta solamente a una capa, se pueden modificar sin alterar al resto de las capas.

## Tecnologías Aplicadas

* Lenguaje de Desarrollo: Java con JDK versión 8.0

* Entorno de desarrollo: Netbeans IDE versión 8.2 - Intellij IDEA 2018

* ORM: Hibernate versión 5.1

* Sistema gestor de base de datos: MySQL versión 5.6

* Modelado del sistema: UML (Lenguaje de modelado unificado) versión 2.0

* Gestor de configuración: Git (Sistema de control de versionado) + Github (Administración de Repositorios).

* Generación de reportes: Jasper Reports - Ireport Versión 5.2

* Maven: project object model (POM) - (Ver archivo de configuración POM.XML)


> Cada miembro del equipo debe crearse una cuenta para acceder al gestor y poder subir las implementaciones del proyecto.

## Diagrama de Entidad-Relación (DER)

## Diagrama de Clases (UML)
 
## Historial de revisiones

|Control de Versionado  |                           |
|-----------------------|---------------------------|
| fecha de creación:    | 15/04/2018                |
| Versión Actual:       | 1.0                       |
| Última Modificación:  | 17/04/2018                |
| Documento:            | ProyectoDelivery.pdf      |
|Equipo de trabajo:     | Araceli, Ramiro, Nicolás  |

# 

|Fecha de modificación  |Involucrados de modificación| Detalle de modificación |
|-----------------------|---------------------------|---------------------------|
| 15/04/2018    | Equipo de trabajo A | Confección del template del documento |
| 15/04/2018    | Equipo de trabajo B | Redacción Intro, Objetivo, limites, alcances del sistema |