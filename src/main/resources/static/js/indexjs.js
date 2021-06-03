/** @author: Karen Orozco
 * Date 02/06/2021*/

$(document).ready(function (){
    $("#tablecontent").hide();
    var URL = window.location;
    $("#buttonEmployee").click(function (event) {
        var id = $("#inputEmployee").val();
        $("#inputEmployee").empty();
        $("#rowContent").empty();
        $("#tablecontent").show();
        $("#rowContent").hide();
        $("#rowContent").show();
        if(id == null || id == ""){
            getEmployees();
        }else{
            getEmployeeDomById(id);
        }
        event.preventDefault();
    })
    /**
     * Función encargada de devolver la infromación de todos los empleados*/
    function getEmployees(){
        $.ajax({
            type : "GET",
            url : URL + "employees",
            success: function(result){
                console.log(result);
                showTable(result);

            },
            error : function(e) {
               // $("#getResultDiv").html("Error");
                console.log("ERROR: ", e);
            }
        })
    }
    /**
     * Función encargada de devolver la información del empleado por ID*/
    function getEmployeeDomById(id){
        $.ajax({
            type : "GET",
            url : URL + "/id/" + id,
            success: function(result){
                console.log(result);
                showTableid(result);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        })
    }
    /**
     * Función que retorna la tabla con el encabezado a mostrar de todos los empleados*/
    function showTable(result){
        for(var i=0; i< result.length; i++){
            $("#rowContent").append("<tr>" +
                "      <td>" + result[i].id + "</td>" +
                "      <td>" + result[i].name + "</td>" +
                "      <td>" + result[i].roleName + "</td>" +
                "      <td>" + result[i].contractTypeName + "</td>" +
                "      <td>" + result[i].salaryAnnual + "</td>" +
                "    </tr>");
        }
    }
    /**
     * Función que retorna el contenido de la tabla a mostrar del empleado por ID*/
    function showTableid(result){
            $("#rowContent").append("<tr>" +
                "      <td>" + result.id + "</td>" +
                "      <td>" + result.name + "</td>" +
                "      <td>" + result.roleName + "</td>" +
                "      <td>" + result.contractTypeName + "</td>" +
                "      <td>" + result.salaryAnnual + "</td>" +
                "    </tr>");
    }

});