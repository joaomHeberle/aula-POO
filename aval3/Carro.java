package aval3;

public class Carro implements Comparable<Carro> {
	private final String nome;
	private String marcha;
	private double velocidade;
	private boolean ligado;

	public Carro(String nome) {
		this.nome = nome;
		marcha = "N";
		velocidade = 0;
		ligado = false;

	}

	public String getNome() {
		return nome;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public char getMarcha() {

		return marcha.charAt(0);
	}

	public boolean isLigado() {
		return ligado;
	}


	
	public void upMarcha() {
		if (marcha.equals("N")) {
			marcha = "1";
		} else if (marcha.equals("5")) {
			marcha = "5";
		}else {
			int teste;
			teste=Integer.parseInt(marcha);
			teste++;
			marcha=String.valueOf(teste);
		}
	}
	public void downMarcha() {
		if (marcha.equals("N")||marcha.equals("1")) {
			marcha = "N";
		}else {
			int teste;
			teste=Integer.parseInt(marcha);
			teste--;
			marcha=String.valueOf(teste);
		}
	}



	@Override
	public String toString() {
		return ligado ? nome + "-> " + "(" + "Ligado" + ", marcha: " + marcha + ", " + velocidade + " km/h" + ")"
				: nome + "-> " + "(" + "Desligado" + ", marcha:" + marcha + ", " + velocidade + ", km/h" + ")";
	}

	private int velMaxima(String mar) {
		int velMax = 20;
		int march;
		march = Integer.parseInt(mar);
		return velMax * march;
	}

	public void acelera(double valor) throws CarroException {

		if (ligado && !marcha.equals("N")) {
			if (velocidade + valor < velMaxima(marcha))
				velocidade = velocidade + valor;
			else if (velocidade + valor > velMaxima(marcha)) 
				velocidade = velMaxima(marcha);
			

		} else {
			throw new CarroException("Para carro andar deve estar ligado e com marcha engatada! Status atual: ligado:"
					+ ligado + ", " + "marcha:" + marcha);
		}

	}

	public void freia(double valor) {
		if (velocidade < valor) {
			velocidade = 0;
		} else {
			velocidade = velocidade - valor;
		}

	}

	public void desliga() {

		ligado = false;

	}

	public void liga() throws CarroException {

		if (marcha.equals("N") && !ligado) {
			ligado = true;
		} else {
			throw new CarroException("Carro engatado, para ligar coloque no Neutro");
		}

	}

	@Override
	public int compareTo(Carro c) {
		if (this.equals(c))
			return 0;
		int ret = this.nome.compareToIgnoreCase(c.nome);
		if (ret == 0) {
			if (this.marcha.equals("N"))
				return -1;
			else if (Integer.parseInt(this.marcha) < Integer.parseInt(c.marcha))
				return -1;
			else
				return +1;
		} else
			return ret;
	}

}
