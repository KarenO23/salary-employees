# Salary-employees

Proyecto que se encarga de calcular el valor del salario anual de un empleado de acuerdo al tipo de contrato ya sea mensual o por horas.

## Despliegue:

Se realizó el despliegue de la aplicación en la plataforma Heroku. Por medio del siguiente enlace podemos acceder a la aplicación WEB del proyecto para validar su funcionamiento.

> http://salary-employees.herokuapp.com/api/

Para validar la documentación de los métodos utilizados para las peticiones se utilizó el pluging Swagger, a la cual podremos acceder desde el siguiente enlace.

> http://salary-employees.herokuapp.com/api/swagger-ui.html

## Métodos de comunicación:

Se implementaron dos métodos de comunicación de tipo GET:

* Employees: Lista la información de todos los empleados con el resultado del cálculo anual del salario del empleado según su tipo de contrato.
  
    > http://salary-employees.herokuapp.com/api/employees
  
* Id/{id_employee} : Recibe como parámetro el Id del empleado y devuelve como resultado la información de dicho empleado y el cálculo del salario anual en base al tipo de contrato.

Se implementa el método que realiza el consumo de la API expuesta para obtener la información de todos los empleados y en base a este realizar el cálculo del salario anual.

## Herramientas utilizadas:
Back-end:

* Lenguaje de programación utilizado es Java, haciendo uso del framework Spring con Gradle
  
* Dependencias para documentación, Swuagger2 y Suagger-UI

Front-end:

* Se hace uso de html 5, Javascript, css con Bootstrap para los estilos.

* Se utiliza la librería JQuery V3.5 para los eventos y la tecnología AJAX para el consumo de los servicios expuestos.
