/** @Author: Karen Orozco
 * Date: 02/06/2021
 * Clase que permite devolver la lista de empleados
 * */

package com.salaryemployees.persistence;

import java.util.ArrayList;

public class Employees {
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
