package banque.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	@Column
	private String benif;

	public String getBenif() {
		return benif;
	}

	public void setBenif(String benif) {
		this.benif = benif;
	}

}
