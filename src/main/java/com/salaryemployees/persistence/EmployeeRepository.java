/** @Author: Karen Orozco
 *  DATE: 02/06/2021
 *  Clase que implementa los metodos definidos en la interfaz EmployeeRepositoryDomain
 *  para el procesamiento de las peticiones
 * */

package com.salaryemployees.persistence;

import com.salaryemployees.domain.EmployeeDom;
import com.salaryemployees.domain.EmployeesDomain;
import com.salaryemployees.domain.repository.EmployeeRepositoryDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class EmployeeRepository implements EmployeeRepositoryDomain {

    /**Método encargado de obtener la información de todos los empleados con el salario calculado*/
    @Override
    public EmployeesDomain getEmployess(){
        Employees employees = getEmployeeRepository();
        EmployeesDomain employeesDomain = new EmployeesDomain();
        ArrayList<EmployeeDom> employeeArrayList = new ArrayList<>();
        for (Employee i : employees.getEmployees()) {
            EmployeeDom employeesDomain1 = getEmployeeDom(i);
            employeeArrayList.add(employeesDomain1);
        }
        employeesDomain.setEmployeesDom(employeeArrayList);

        return employeesDomain;
    }

    /**Método encargado de devolver la información de un empleado cuando es llamado por su ID*/
    @Override
    public EmployeeDom getEmployeeDomById(int id){
        ArrayList<Employee> employees = getEmployeeRepository().getEmployees();
        EmployeeDom employeeDom = new EmployeeDom();
        boolean flag = false;
        for (Employee i: employees) {
            if(i.getId() == id) {
                employeeDom = getEmployeeDom(i);
                flag= true;
            }
        }
        if(flag){
            return employeeDom;
        } else{
            return null;
        }
    }

    /**Método encargado de obtener la información del valor anual saliarial calculado por mes o horas*/
    private EmployeeDom getEmployeeDom(Employee i){
        EmployeeDom employeesDomain1 = new EmployeeDom();
        employeesDomain1.setId(i.getId());
        employeesDomain1.setName(i.getName());
        employeesDomain1.setContractTypeName(i.getContractTypeName());
        employeesDomain1.setRoleName(i.getRoleName());
        if(i.getContractTypeName().equals("HourlySalaryEmployee")) {
            employeesDomain1.setSalaryAnnual(caculoSalaryAnual(i.getHourlySalary()));
        }else {
            double valor=0.0;
            valor = (i.getMonthlySalary()/120); //Se toma el valor del mes que son 50000 y se divide en 120 que son las horas trabajadas por mes
            employeesDomain1.setSalaryAnnual(caculoSalaryAnual(valor));
        }
        return employeesDomain1;
    }
    /**Método encargado de consumir la información del API para añadirla en una lista*/
    private Employees getEmployeeRepository(){

        ResponseEntity<Employee[]> plantilla=
                new RestTemplate()
                        .getForEntity("http://masglobaltestapi.azurewebsites.net/api/employees", Employee[].class);
        Employee[] employeearr = plantilla.getBody();
        ArrayList<Employee> arrayEmployess = new ArrayList<>();
        for (int i=0; i< employeearr.length; i++){
            Employee employee = new Employee();
            employee.setId(employeearr[i].getId());
            employee.setName(employeearr[i].getName());
            employee.setContractTypeName(employeearr[i].getContractTypeName());
            employee.setRoleId(employeearr[i].getRoleId());
            employee.setRoleName(employeearr[i].getRoleName());
            employee.setRoleDescription(employeearr[i].getRoleDescription());
            employee.setHourlySalary(employeearr[i].getHourlySalary());
            employee.setMonthlySalary(employeearr[i].getMonthlySalary());

            arrayEmployess.add(employee);
        }

        Employees listEmployees = new Employees();
        listEmployees.setEmployees(arrayEmployess);
        return listEmployees;
    }
    /**Método encargado realizar el calculo del salario anual*/
    private double caculoSalaryAnual(double salary){
       return (double) (120.0 * salary * 12.0);
    }
}
