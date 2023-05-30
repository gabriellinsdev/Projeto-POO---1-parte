/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematelefoniajava;
import java.util.Date;
/**
 *
 * @author gabri
 */
public class Recarga {
	private float valor;
	private Date data;
	
	public Recarga(Date data, float valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "Recarga [data=" + data + ", valor=" + valor + " reais]";
	}
}
