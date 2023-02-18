package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	//Constante no Java
	private final static float RENDIMENTO = 0.05f;
	
	//Contrutores padrão e o com todos
	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public double calculaRetornoInvestimento() {
		return 0;
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void retirar(double valor) throws Exception{
		if (saldo < valor + taxa) {
			throw new Exception("Saldo insuficiente");
		}
		saldo -= valor + taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
