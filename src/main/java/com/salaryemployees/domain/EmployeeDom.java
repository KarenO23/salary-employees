/**@Author: Karen Orozco
 * Date: 02/06/2021
 * Clase que define los parametros que retornara el empleado
 * * */

package com.salaryemployees.domain;

public class EmployeeDom {

    private int id;
    private String name;
    private String contractTypeName;
    private String roleName;
    private double salaryAnnual;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getSalaryAnnual() {
        return salaryAnnual;
    }

    public void setSalaryAnnual(double salaryAnnual) {
        this.salaryAnnual = salaryAnnual;
    }

}
