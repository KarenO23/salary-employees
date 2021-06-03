/**@Author: Karen Orozco
 * date: 02/06/2021
 * Se define el controlador de la aplicación, rutas y métodos a procesar en la API* */

package com.salaryemployees.web.controller;

import com.salaryemployees.domain.EmployeeDom;
import com.salaryemployees.domain.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("Metodo encargado de devolver una lista de los empleados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "No hay información.")
    })
    @GetMapping("/employees")
    public ResponseEntity <ArrayList<EmployeeDom>> getEmployees(){
        ArrayList<EmployeeDom> employeeDomArrayList = employeeService.getEmployees().getEmployeesDom();
        return new ResponseEntity<>(employeeDomArrayList, HttpStatus.OK);
    }

    @ApiOperation("Método encargaddo de devolver la información de un empleado por el ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "No hay información.")
    })
    @GetMapping("/id/{id_employee}")
    public ResponseEntity <EmployeeDom> getEmployees(@PathVariable("id_employee") int id){
        EmployeeDom employeeDom = employeeService.getEmployeeDomById(id);
        if(employeeDom != null){
            return new ResponseEntity<>(employeeDom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
