/**@Author: Karen Orozco
 * Date: 02/06/2021
 * Clase que define la lista de empleados a retornar
 * */

package com.salaryemployees.domain;

import java.util.ArrayList;

public class EmployeesDomain {

    ArrayList<EmployeeDom> employeesDom = new ArrayList<>();

    public ArrayList<EmployeeDom> getEmployeesDom() {
        return employeesDom;
    }

    public void setEmployeesDom(ArrayList<EmployeeDom> employeesDom) {
        this.employeesDom = employeesDom;
    }
}
