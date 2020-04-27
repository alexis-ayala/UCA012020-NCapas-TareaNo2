package com.uca.ncapas.tareano2.controller;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.*;
import java.time.*; 
import java.time.DayOfWeek; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/alumno")
	public @ResponseBody String alumno() {
		String texto = "<h2>Información de Alumno.</h2>";
		texto += "<table border=1>" + 
				 	"<tbody>" +
				 		"<tr>" +
				 			"<td><b>Nombres:</b></td>" +
				 			"<td>Leandro Alexis</td>" +
				 		"</tr>" +
				 		"<tr>" +
				 			"<td><b>Apellidos:</b></td>" +
				 			"<td>Ayala Hernández</td>" +
				 		"</tr>" +
				 		"<tr>" +
				 			"<td><b>Carnet:</b></td>" +
				 			"<td>00081211</td>" +
				 		"</tr>" +
				 		"<tr>" +
				 			"<td><b>Carrera Estudio:</b></td>" +
				 			"<td>Ingeniería Informática.</td>" +
				 		"</tr>" +
				 		"<tr>" +
				 			"<td><b>Año Cursado:</b></td>" +
				 			"<td>Cuarto Año.</td>" +
				 		"</tr>" +
				 	"</tbody>" +
				 "</table>";
		return texto;
	}

	@RequestMapping("/diasemana")
	public @ResponseBody String diasemana(HttpServletRequest request) {
		if(isNumeric(request.getParameter("dia")) && isNumeric(request.getParameter("mes")) && isNumeric(request.getParameter("año"))) {
			Integer anio = Integer.parseInt(request.getParameter("año"));
			Integer mes = Integer.parseInt(request.getParameter("mes"));
			Integer dia = Integer.parseInt(request.getParameter("dia"));
			try {  
				String fecha = "Fecha ingresada: <b>" + (dia<10 ? "0" + dia : dia) + "/" + (mes<10 ? "0" + mes : mes) + "/" + anio;
		        DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.of(anio, mes, dia)); 
		        dia = dayOfWeek.getValue();
		        return fecha + "</b>, día de semana <b>" + (new String[] {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"})[dia-1] + "</b>.";
			}catch(Exception ex) {
				
			}
		}
		return "<h3>Parametros ingresados son incorrectos.</h3>";
	}
	public boolean isNumeric(String strNum) {
	    try {
	        Integer.parseInt(strNum);
	        return true;
	    } catch (NumberFormatException nfe) {
	    }
	    return false;
	}
}
