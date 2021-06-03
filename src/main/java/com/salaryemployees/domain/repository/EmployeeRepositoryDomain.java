/** @Author: KOROZCO
 * Date: 02/06/2021
 * Interfaz que define los métodos  retornando la respuesta de la API
 * */

package com.salaryemployees.domain.repository;

import com.salaryemployees.domain.EmployeeDom;
import com.salaryemployees.domain.EmployeesDomain;

public interface EmployeeRepositoryDomain {

    EmployeesDomain getEmployess();
    EmployeeDom getEmployeeDomById(int id);
}
