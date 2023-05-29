/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistematelefoniajava;
import java.util.Date;
/**
 *
 * @author gabri
 */
public class Telefonia {
	private PrePago[] prePagos;
	private int numPrePagos;
	private PosPago[] posPagos;
	private int numPosPagos;
	
	public Telefonia() {
		super();
		this.prePagos = new PrePago[1];
		this.posPagos = new PosPago[1];
	}
	
	public void cadastrarAssinante(int opcao, String nome, long cpf, int numero, float assinatura) {
		if(opcao == 1) {
            if (numPosPagos >= this.prePagos.length) {
                System.out.println("Erro: O número máximo de assinantes foi alcançado.");
                return;
            }
			this.numPosPagos++;
			for (int i = 0; i < numPosPagos; i++) {
				if(this.posPagos[i] == null) {
					PosPago posp = new PosPago(numero, cpf, nome, assinatura);
					this.posPagos[i] = posp;
					System.out.println("Seu cadastro foi realizado com sucesso!");
				}
			}
			
		} else if (opcao == 2) {
            if (numPrePagos >= this.prePagos.length) {
                System.out.println("Erro: O número máximo de assinantes foi alcançado.");
                return;
            }
			this.numPrePagos++;
			for (int i = 0; i < numPrePagos; i++) {
				if (this.prePagos[i] == null) {
					PrePago prep = new PrePago(cpf, nome, numero);
					this.prePagos[i] = prep;
					System.out.println("Seu cadastro foi realizado com sucesso!");
				} 
			}
		}
	}
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
