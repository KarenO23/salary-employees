/**@Author: Karen Orozco
 * Date: 02/06/2021
 * Clase que permite la comunicación entre el reporsitorio y el controlador,
 * para el procesamiento de las peticiones
 * */

package com.salaryemployees.domain.service;
import com.salaryemployees.domain.EmployeeDom;
import com.salaryemployees.domain.EmployeesDomain;
import com.salaryemployees.domain.repository.EmployeeRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositoryDomain employeeRepositoryDomain;

    public EmployeesDomain getEmployees(){
        return employeeRepositoryDomain.getEmployess();
    }
    public EmployeeDom getEmployeeDomById(int id){
        return employeeRepositoryDomain.getEmployeeDomById(id);
    }
}
