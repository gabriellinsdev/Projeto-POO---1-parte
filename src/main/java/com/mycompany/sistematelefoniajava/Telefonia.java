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
	
	public void listarAssinantes() {
		System.out.println("Assinantes pré pagos: ");
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prePagos[i] != null){
			System.out.println(this.prePagos[i].toString());
			}
		}
		System.out.println();
		System.out.println("Assinantes pós pagos: ");
		for (int i = 0; i < numPosPagos; i++) {
			if(this.posPagos[i] != null) {
			System.out.println(this.posPagos[i].toString());
			}
		}
		System.out.println();
	}
	
	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i <= numPrePagos; i++) {
			if (this.prePagos[i] != null) {
				if (this.prePagos[i].getCpf() == cpf) {
					return this.prePagos[i];
			}
			} else {
				i++;
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i <= numPosPagos; i++) {
			if (this.posPagos[i] != null) {
			if (this.posPagos[i].getCpf() == cpf) {
				return this.posPagos[i];
			} 
			}
			else {
				i++;
			}
		}
		return null;
	}
	
	public void fazerChamada(int opcao, long cpf, Date data, int duracao) {
		if (opcao == 1) { 
			if (this.localizarPosPago(cpf) != null) {
				PosPago cham = this.localizarPosPago(cpf);
				cham.fazerChamada(data, duracao);
				System.out.println("A chamada foi realizada.");
			} else {
				System.out.println("O assinante não foi encontrado no sistema.");
			}
		} else if (opcao == 2) {
			if (this.localizarPrePago(cpf) != null) {
				PrePago cham = this.localizarPrePago(cpf);
				cham.fazerChamada(data, duracao);
			} else {
				System.out.println("O assinante não foi encontrado no sistema.");
			}
		} else {
			System.out.println("Escolha outra opção.");
		}
	}

	public void fazerRecarga(long cpf, float valor, Date data) {
		if (this.localizarPrePago(cpf) != null) {
			PrePago rec = this.localizarPrePago(cpf);
			rec.recarregar(data, valor);
			System.out.println("Recarga realizada."); 
		} else {
			System.out.println("O assinante não foi encontrado no sistema."); 
		}
	}

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}