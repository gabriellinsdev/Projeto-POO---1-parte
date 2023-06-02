/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sistematelefoniajava;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

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
        if (opcao == 1) {
            if (numPosPagos >= this.prePagos.length) {
                System.out.println("Erro: O número máximo de assinantes foi alcançado.");
                return;
            }
            this.numPosPagos++;
            for (int i = 0; i < numPosPagos; i++) {
                if (this.posPagos[i] == null) {
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
            if (this.prePagos[i] != null) {
                System.out.println(this.prePagos[i].toString());
            }
        }
        System.out.println();
        System.out.println("Assinantes pós pagos: ");
        for (int i = 0; i < numPosPagos; i++) {
            if (this.posPagos[i] != null) {
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
            } else {
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
        Telefonia t = new Telefonia();
        Date d = new Date();

        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int op = 0;
        String nome = "";
        long cpf = 0;
        int numero = 0;
        int duracao = 0;
        int pp = 0;
        float assinatura = 0;
        float rec = 0;
        int mes = 0;
        while (op != 6) {
            System.out.println("Digite uma opção:\n1.Cadastrar assinante\n2.Listar assinantes\n3.Fazer chamada\n4.Fazer recarga\n5.Imprimir faturas\n6.Sair");
            op = s.nextInt();
            if (op == 1) {
                //Cadastrar assinante
                System.out.println("A assinatura será de:\n1.Pós pago\n2.Pré Pago");
                pp = s.nextInt();
                s.nextLine();
                if (pp == 1) {
                    System.out.println("Nome: ");
                    nome = s.nextLine();
                    System.out.println("CPF: ");
                    cpf = s.nextLong();
                    System.out.println("Número: ");
                    numero = s.nextInt();
                    System.out.println("Assinatura: ");
                    assinatura = s.nextFloat();

                } else if (pp == 2) {
                    //Listar assinantes
                    System.out.println("Nome: ");
                    nome = s.nextLine();
                    System.out.println("CPF: ");
                    cpf = s.nextLong();
                    System.out.println("Número: ");
                    numero = s.nextInt();
                } else {
                    System.out.println("Escolha outra opção.");
                }
                t.cadastrarAssinante(pp, nome, cpf, numero, assinatura);
            } else if (op == 2) {
                t.listarAssinantes();
            } else if (op == 3) {
                //Fazer chamada
                System.out.println("Sua assinatura é:\n1.Pós Pago\n2.Pré Pago");
                pp = s.nextInt();
                System.out.println("Digite seu CPF: ");
                cpf = s.nextLong();
                System.out.println("Digite a duração da ligação: ");
                duracao = s.nextInt();
                t.fazerChamada(pp, cpf, d, duracao);
            } else if (op == 4) {
                //Fazer recarga
                System.out.println("Digite seu CPF: ");
                cpf = s.nextLong();
                System.out.println("Digite o valor da recarga, em reais: ");
                rec = s.nextFloat();
                t.fazerRecarga(cpf, rec, d);
            } else if (op == 5) {
                //Imprimir faturas
                System.out.println("Digite o mês em que deseja visualizar as faturas: ");
                mes = s.nextInt();
                int mesFatura = mes - 1;
                t.imprimirFaturas(mesFatura);
            }
        }
        s.close();
    }

    public void imprimirFaturas(int mes) {
        DecimalFormat formatador = new DecimalFormat("0.00");
        for (int i = 0; i < numPrePagos; i++) {
            if (this.prePagos[i].numChamadas > 0) {
                this.prePagos[i].imprimirFatura(mes);
            } else {
                System.out.println("Fatura assinante pré pago:");
                System.out.println(this.prePagos[i]);
                System.out.println("O assinante não efetuou ligações nesse mês.");
                System.out.println("Créditos: R$" + formatador.format(this.prePagos[i].creditos));
            }
            System.out.println();
        }
        for (int i = 0; i < numPosPagos; i++) {
            if (this.posPagos[i].numChamadas > 0) {
                this.posPagos[i].imprimirFatura(mes);
            } else {
                System.out.println("Fatura assinante pós pago:");
                System.out.println(this.posPagos[i]);
                System.out.println("O assinante não efetuou ligações nesse mês.");
                System.out.println("Assinatura: R$" + formatador.format(this.posPagos[i].assinatura));
                System.out.println("Valor da fatura: R$" + formatador.format(this.posPagos[i].assinatura));
            }
            System.out.println();
        }
    }
}
