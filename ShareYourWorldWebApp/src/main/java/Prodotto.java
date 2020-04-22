import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Prodotto {
	@Size (min=3, max=20)
	private String nome;
	
	
	@Size (min=3, max=50)

	private String codiceABarre;
	@Min(3)
	@Max(3)
	private Integer prezzo;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceABarre() {
		return codiceABarre;
	}

	public void setCodiceABarre(String codiceABarre) {
		this.codiceABarre = codiceABarre;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

}
