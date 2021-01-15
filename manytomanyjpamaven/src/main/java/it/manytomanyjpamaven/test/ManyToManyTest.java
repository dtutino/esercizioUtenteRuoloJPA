package it.manytomanyjpamaven.test;

import java.util.Date;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;
import it.manytomanyjpamaven.service.MyServiceFactory;
import it.manytomanyjpamaven.service.RuoloService;
import it.manytomanyjpamaven.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
			initRuoli(ruoloServiceInstance);

			
			System.out.println("LA LISTA DEGLI UTENTI:");
			System.out.println("Elenca utenti: ");
			for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
			}

			Utente utenteNuovo = new Utente("mario.rossi", "xxx", "Mario", "Rossi", new Date());
			Utente utenteNuovo2 = new Utente("pippo.pluto", "yyy", "Pippo", "Pluto", new Date());
			Utente utenteNuovo3 = new Utente("fabio.gialli", "vvv", "Fabio", "Gialli", new Date()); 
//			utenteServiceInstance.inserisciNuovo(utenteNuovo);
//			utenteServiceInstance.inserisciNuovo(utenteNuovo2);
//			utenteServiceInstance.inserisciNuovo(utenteNuovo3);
			
			System.out.println("CERCO UN UTENTE PER ID:");
			System.out.println(utenteServiceInstance.caricaSingoloElemento(2L));
			
			
//			System.out.println("AGGIORNO UN UTENTE:");
//			utenteNuovo.setPassword("zzz");
//			utenteServiceInstance.aggiorna(utenteNuovo);
//			System.out.println(utenteNuovo);
			
//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);
//
//			Utente utenteDaDb = utenteServiceInstance.caricaSingoloElemento(2L);
//			if (utenteDaDb != null) {
//				utenteServiceInstance.aggiungiRuolo(utenteDaDb, ruoloDaDb);
//			}
//			
//			Ruolo ruoloDaDb2 = ruoloServiceInstance.caricaSingoloElemento(2L);
//
//			Utente utenteDaDb4 = utenteServiceInstance.caricaSingoloElemento(3L);
//			if (utenteDaDb != null) {
//				utenteServiceInstance.aggiungiRuolo(utenteDaDb4, ruoloDaDb2);
//			}
			
//			// provo a eliminare un utente
//			utenteServiceInstance.rimuovi(utenteDaDb4);

			// proviamo a passarlo nello stato ATTIVO
//			Utente utenteDaDb2 = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
//			if (utenteDaDb2 != null) {
//				System.out.println(
//						"stato attuale dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//				utenteDaDb2.setStato(StatoUtente.ATTIVO);
//				utenteServiceInstance.aggiorna(utenteDaDb2);
//				System.out.println(
//						"stato nuovo dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//			}
//			
//			System.out.println("LISTA DEI RUOLI:");
//			for (Ruolo ruoloItem : ruoloServiceInstance.listAll()) {
//				System.out.println(ruoloItem);
//			}
//			
//			// aggiorno ruolo 
//			ruoloDaDb.setDescrizione("Amministratore");
//			ruoloServiceInstance.aggiorna(ruoloDaDb);
			
			// provo a rimuovere un ruolo 
//			Ruolo ruoloDaDb2 = ruoloServiceInstance.caricaSingoloElemento(1L);
//			ruoloServiceInstance.rimuovi(ruoloDaDb2);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
		}
	}

}
