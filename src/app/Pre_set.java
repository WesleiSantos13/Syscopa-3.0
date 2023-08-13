package app;

import java.util.ArrayList ;

import app.Dao.ArbitroDaoImpl;
import app.Dao.FaseGruposDaoImpl;
import app.Dao.GrupoDaoImpl;
import app.Dao.JogadorDaoImpl;
import app.Dao.SelecaoDaoImpl;
import app.Dao.TecnicoDaoImpl;
import app.model.Arbitro;
import app.model.Funcoes;
import app.model.Grupo;
import app.model.Jogador;
import app.model.Partida;
import app.model.Selecao;
import app.model.Tecnico;


/* Classe responsavel pelo pre-set de selecoes, jogadores, tecnicos e grupos
 * 
 * @author Weslei Silva Santos
 *
 */
public class Pre_set {
	
	/** Metodo unico do pre set
	 * 
	 */
	public static void construir() {
		SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl();
		TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();
		GrupoDaoImpl grupoDao = new GrupoDaoImpl();
		
		
		
		//Adicionando os ids de jogadores numa lista para colocar dentro das selecoes
		ArrayList<Integer>jogadores1 = new ArrayList<>();
		for(int i=1; i<12; i++) {
			jogadores1.add(i);}
		
		
		ArrayList<Integer>jogadores2 = new ArrayList<>();
		for(int i=12; i<23; i++) {
			jogadores2.add(i);}
		
		
		ArrayList<Integer>jogadores3 = new ArrayList<>();
		for(int i=23; i<34; i++) {
			jogadores3.add(i);}
		
		ArrayList<Integer>jogadores4 = new ArrayList<>();
		for(int i=34; i<45; i++) {
			jogadores4.add(i);}
		
		ArrayList<Integer>jogadores5 = new ArrayList<>();
		for(int i=45; i<56; i++) {
			jogadores5.add(i);}
		
		ArrayList<Integer>jogadores6 = new ArrayList<>();
		for(int i=56; i<67; i++) {
			jogadores6.add(i);}
		
		ArrayList<Integer>jogadores7 = new ArrayList<>();
		for(int i=67; i<78; i++) {
			jogadores7.add(i);}
		
		ArrayList<Integer>jogadores8 = new ArrayList<>();
		for(int i=78; i<89; i++) {
			jogadores8.add(i);}

		ArrayList<Integer>jogadores9 = new ArrayList<>();
		for(int i=89; i<100; i++) {
			jogadores9.add(i);}
		
		ArrayList<Integer>jogadores10 = new ArrayList<>();
		for(int i=100; i<111; i++) {
			jogadores10.add(i);}
		
		
		
		
		ArrayList<Integer>jogadores11 = new ArrayList<>();
		for(int i=111; i<122; i++) {
			jogadores11.add(i);}
		
		
		ArrayList<Integer>jogadores12 = new ArrayList<>();
		for(int i=122; i<133; i++) {
			jogadores12.add(i);}
		
		
		ArrayList<Integer>jogadores13 = new ArrayList<>();
		for(int i=133; i<144; i++) {
			jogadores13.add(i);}
		
		ArrayList<Integer>jogadores14 = new ArrayList<>();
		for(int i=144; i<155; i++) {
			jogadores14.add(i);}
		
		ArrayList<Integer>jogadores15 = new ArrayList<>();
		for(int i=155; i<166; i++) {
			jogadores15.add(i);}
		
		ArrayList<Integer>jogadores16 = new ArrayList<>();
		for(int i=166; i<177; i++) {
			jogadores16.add(i);}
		
		ArrayList<Integer>jogadores17 = new ArrayList<>();
		for(int i=177; i<188; i++) {
			jogadores17.add(i);}
		
		ArrayList<Integer>jogadores18 = new ArrayList<>();
		for(int i=188; i<199; i++) {
			jogadores18.add(i);}

		ArrayList<Integer>jogadores19 = new ArrayList<>();
		for(int i=199; i<210; i++) {
			jogadores19.add(i);}
		
		ArrayList<Integer>jogadores20 = new ArrayList<>();
		for(int i=210; i<221; i++) {
			jogadores20.add(i);}
		
		
		
		

		ArrayList<Integer>jogadores21 = new ArrayList<>();
		for(int i=221; i<232; i++) {
			jogadores21.add(i);}
		
		
		ArrayList<Integer>jogadores22 = new ArrayList<>();
		for(int i=232; i<243; i++) {
			jogadores22.add(i);}
		
		
		ArrayList<Integer>jogadores23 = new ArrayList<>();
		for(int i=243; i<254; i++) {
			jogadores23.add(i);}
		
		ArrayList<Integer>jogadores24 = new ArrayList<>();
		for(int i=254; i<265; i++) {
			jogadores24.add(i);}
		
		ArrayList<Integer>jogadores25 = new ArrayList<>();
		for(int i=265; i<276; i++) {
			jogadores25.add(i);}
		
		ArrayList<Integer>jogadores26 = new ArrayList<>();
		for(int i=276; i<287; i++) {
			jogadores26.add(i);}
		
		ArrayList<Integer>jogadores27 = new ArrayList<>();
		for(int i=287; i<298; i++) {
			jogadores27.add(i);}
		
		ArrayList<Integer>jogadores28 = new ArrayList<>();
		for(int i=298; i<309; i++) {
			jogadores28.add(i);}

		ArrayList<Integer>jogadores29 = new ArrayList<>();
		for(int i=309; i<320; i++) {
			jogadores29.add(i);}
		
		ArrayList<Integer>jogadores30 = new ArrayList<>();
		for(int i=320; i<331; i++) {
			jogadores30.add(i);}
		
		

		ArrayList<Integer>jogadores31 = new ArrayList<>();
		for(int i=331; i<342; i++) {
			jogadores31.add(i);}
		
		ArrayList<Integer>jogadores32 = new ArrayList<>();
		for(int i=342; i<353; i++) {
			jogadores32.add(i);}
		
		
		
		
	
		
		
		
		
		//Criando ids de tecnicos para armazenar na selecoes
		
		ArrayList<Integer>tecnico1 = new ArrayList<>();
		tecnico1.add(1);
		ArrayList<Integer>tecnico2 = new ArrayList<>();
		tecnico2.add(2);
		ArrayList<Integer>tecnico3 = new ArrayList<>();
		tecnico3.add(3);
		ArrayList<Integer>tecnico4 = new ArrayList<>();
		tecnico4.add(4);
		ArrayList<Integer>tecnico5 = new ArrayList<>();
		tecnico5.add(5);
		ArrayList<Integer>tecnico6 = new ArrayList<>();
		tecnico6.add(6);
		ArrayList<Integer>tecnico7 = new ArrayList<>();
		tecnico7.add(7);
		ArrayList<Integer>tecnico8 = new ArrayList<>();
		tecnico8.add(8);
		ArrayList<Integer>tecnico9 = new ArrayList<>();
		tecnico9.add(9);
		ArrayList<Integer>tecnico10 = new ArrayList<>();
		tecnico10.add(10);
		ArrayList<Integer>tecnico11 = new ArrayList<>();
		tecnico11.add(11);
		ArrayList<Integer>tecnico12 = new ArrayList<>();
		tecnico12.add(12);
		ArrayList<Integer>tecnico13 = new ArrayList<>();
		tecnico13.add(13);
		ArrayList<Integer>tecnico14 = new ArrayList<>();
		tecnico14.add(14);
		ArrayList<Integer>tecnico15 = new ArrayList<>();
		tecnico15.add(15);
		ArrayList<Integer>tecnico16 = new ArrayList<>();
		tecnico16.add(16);
		ArrayList<Integer>tecnico17 = new ArrayList<>();
		tecnico17.add(17);
		ArrayList<Integer>tecnico18 = new ArrayList<>();
		tecnico18.add(18);
		ArrayList<Integer>tecnico19 = new ArrayList<>();
		tecnico19.add(19);
		ArrayList<Integer>tecnico20 = new ArrayList<>();
		tecnico20.add(20);
		ArrayList<Integer>tecnico21 = new ArrayList<>();
		tecnico21.add(21);
		ArrayList<Integer>tecnico22 = new ArrayList<>();
		tecnico22.add(22);
		ArrayList<Integer>tecnico23 = new ArrayList<>();
		tecnico23.add(23);
		ArrayList<Integer>tecnico24 = new ArrayList<>();
		tecnico24.add(24);
		ArrayList<Integer>tecnico25 = new ArrayList<>();
		tecnico25.add(25);
		ArrayList<Integer>tecnico26 = new ArrayList<>();
		tecnico26.add(26);
		ArrayList<Integer>tecnico27 = new ArrayList<>();
		tecnico27.add(27);
		ArrayList<Integer>tecnico28 = new ArrayList<>();
		tecnico28.add(28);
		ArrayList<Integer>tecnico29 = new ArrayList<>();
		tecnico29.add(29);
		ArrayList<Integer>tecnico30 = new ArrayList<>();
		tecnico30.add(30);
		
		ArrayList<Integer>tecnico31 = new ArrayList<>();
		tecnico30.add(31);
		ArrayList<Integer>tecnico32 = new ArrayList<>();
		tecnico30.add(32);
		
		
		//Criando Selecoes
		Selecao selecao1= new Selecao(1, "HOLANDA", jogadores1, tecnico1, 1, 0, 0, 0);
		selecaoDao.CreateSelecao(selecao1);
		Selecao selecao2= new Selecao(2, "EQUADOR", jogadores2, tecnico2, 1, 0, 0,0);
		selecaoDao.CreateSelecao(selecao2);
		Selecao selecao3= new Selecao(3, "SENEGAL",jogadores3, tecnico3,1, 0, 0,0);
		selecaoDao.CreateSelecao(selecao3);
		Selecao selecao4= new Selecao(4, "CATAR", jogadores4, tecnico4, 1, 0, 0,0);
		selecaoDao.CreateSelecao(selecao4);
		
		Selecao selecao5= new Selecao(5, "INGLATERRA", jogadores5,tecnico5, 2, 0, 0,0);
		selecaoDao.CreateSelecao(selecao5);
		Selecao selecao6= new Selecao(6, "IRA", jogadores6,tecnico6, 2, 0, 0,0);
		selecaoDao.CreateSelecao(selecao6);
		Selecao selecao7= new Selecao(7, "ESTADOS UNIDOS", jogadores7, tecnico7, 2, 0, 0,0);
		selecaoDao.CreateSelecao(selecao7);
		Selecao selecao8= new Selecao(8, "GALES", jogadores8, tecnico8,  2, 0, 0,0);
		selecaoDao.CreateSelecao(selecao8);
		
		Selecao selecao9= new Selecao(9, "POLONIA", jogadores9, tecnico9,  3, 0, 0,0);
		selecaoDao.CreateSelecao(selecao9);
		Selecao selecao10= new Selecao(10, "ARGENTINA", jogadores10, tecnico10,  3, 0, 0,0);
		selecaoDao.CreateSelecao(selecao10);
		Selecao selecao11= new Selecao(11, "ARABIA SAUDITA", jogadores11, tecnico11, 3, 0, 0,0);
		selecaoDao.CreateSelecao(selecao11);
		Selecao selecao12= new Selecao(12, "MEXICO", jogadores12, tecnico12, 3, 0, 0,0);
		selecaoDao.CreateSelecao(selecao12);
		
		Selecao selecao13= new Selecao(13, "FRANÇA", jogadores13,tecnico13, 4, 0, 0,0);
		selecaoDao.CreateSelecao(selecao13);
		Selecao selecao14= new Selecao(14, "DINAMARCA",jogadores14,tecnico14, 4, 0, 0,0);
		selecaoDao.CreateSelecao(selecao14);
		Selecao selecao15= new Selecao(15, "TUNISIA", jogadores15, tecnico15,  4, 0, 0,0);
		selecaoDao.CreateSelecao(selecao15);
		Selecao selecao16= new Selecao(16, "AUSTRALIA",jogadores16, tecnico16, 4, 0, 0,0);
		selecaoDao.CreateSelecao(selecao16);
		
		Selecao selecao17= new Selecao(17, "ESPANHA", jogadores17, tecnico17,  5, 0, 0,0);
		selecaoDao.CreateSelecao(selecao17);
		Selecao selecao18= new Selecao(18, "JAPAO", jogadores18, tecnico18, 5, 0, 0,0);
		selecaoDao.CreateSelecao(selecao18);
		Selecao selecao19= new Selecao(19, "COSTA RICA", jogadores19, tecnico19, 5, 0, 0,0);
		selecaoDao.CreateSelecao(selecao19);
		Selecao selecao20= new Selecao(20, "ALEMANHA", jogadores20, tecnico20, 5, 0, 0,0);
		selecaoDao.CreateSelecao(selecao20);
		
		Selecao selecao21= new Selecao(21, "CROACIA", jogadores21, tecnico21,  6, 0, 0,0);
		selecaoDao.CreateSelecao(selecao21);
		Selecao selecao22= new Selecao(22, "MARROCOS",jogadores22, tecnico22, 6, 0, 0,0);
		selecaoDao.CreateSelecao(selecao22);
		Selecao selecao23= new Selecao(23, "BELGICA", jogadores23, tecnico23,  6, 0, 0,0);
		selecaoDao.CreateSelecao(selecao23);
		Selecao selecao24= new Selecao(24, "CANADA", jogadores24, tecnico24, 6, 0, 0,0);
		selecaoDao.CreateSelecao(selecao24);
		
		Selecao selecao25= new Selecao(25, "BRASIL", jogadores25,tecnico25,  7, 0, 0,0);
		selecaoDao.CreateSelecao(selecao25);
		Selecao selecao26= new Selecao(26, "SUIÇA", jogadores26, tecnico26,  7, 0, 0,0);
		selecaoDao.CreateSelecao(selecao26);
		Selecao selecao27= new Selecao(27, "CAMAROES", jogadores27, tecnico27, 7, 0, 0,0);
		selecaoDao.CreateSelecao(selecao27);
		Selecao selecao28= new Selecao(28, "SERVIA", jogadores28, tecnico28,  7, 0, 0,0);
		selecaoDao.CreateSelecao(selecao28);
		
		Selecao selecao29= new Selecao(29, "URUGUAI", jogadores29,tecnico29,  8, 0, 0,0);
		selecaoDao.CreateSelecao(selecao29);
		Selecao selecao30= new Selecao(30, "PORTUGAL", jogadores30, tecnico30,  8, 0, 0,0);
		selecaoDao.CreateSelecao(selecao30);
		Selecao selecao31= new Selecao(31, "COREIA DO SUL", jogadores31, tecnico31,8, 0, 0,0);
		selecaoDao.CreateSelecao(selecao31);
		Selecao selecao32= new Selecao(32, "GANA", jogadores32, tecnico32, 8, 0, 0,0);
		selecaoDao.CreateSelecao(selecao32);
		
		
		// Guardando ids das selecoes pra criar os grupos
		ArrayList<Integer>selecoes1 = new ArrayList<>();
		ArrayList<Integer>selecoes2 = new ArrayList<>(); 
		ArrayList<Integer>selecoes3 = new ArrayList<>(); 
		ArrayList<Integer>selecoes4 = new ArrayList<>(); 
		ArrayList<Integer>selecoes5 = new ArrayList<>(); 
		ArrayList<Integer>selecoes6 = new ArrayList<>(); 
		ArrayList<Integer>selecoes7 = new ArrayList<>(); 
		ArrayList<Integer>selecoes8 = new ArrayList<>(); 
		
		for(int i=1;i<5;i++) {
			selecoes1.add(i);}
		
		for(int i=5;i<9;i++) {
			selecoes2.add(i);}
		
		for(int i=9;i<13;i++) {
			selecoes3.add(i);}
		
		
		for(int i=13;i<17;i++) {
			selecoes4.add(i);}
		
		for(int i=17;i<21;i++) {
			selecoes5.add(i);}
		
		for(int i=21;i<25;i++) {
			selecoes6.add(i);}
		
		for(int i=25;i<29;i++) {
			selecoes7.add(i);}
		
		for(int i=29;i<33;i++) {
			selecoes8.add(i);}
		
		int z = 0;
		int a= 1;
		for(int i =1; i<353;i++) {
			if(z==11) {	
				a++;
				z=0;}
			// Criando Jogadores no Dao
			Jogador jogador = new Jogador(i, "TESTE", "ATACANTE", 0, 0, 0, a);
			jogadorDao.Create(jogador);
			z++;}
		
		String nameSelecoes[]= {"HOLANDA", "EQUADOR", "SENEGAL", "CATAR",
				"INGLATERRA","IRA","ESTADOS UNIDOS","GALES",
				"POLONIA", "ARGENTINA", "ARABIA SAUDITA","MEXICO",
				"FRANÇA", "DINAMARCA", "TUNISIA", "AUSTRALIA",
				 "ESPANHA", "JAPAO", "COSTA RICA", "ALEMANHA",
				 "CROACIA", "MARROCOS","BELGICA", "CANADA",
				 "BRASIL", "SUIÇA", "CAMAROES", "SERVIA",
				 "URUGUAI", "PORTUGAL", "COREIA DO SUL",  "GANA"};
		
		//Criando tecnicos no Dao
		for(int i=0; i<32; i++){
			Tecnico Tecnico = new Tecnico(i+1, "TEC", i+1, nameSelecoes[i]);
			tecnicoDao.CreateTec(Tecnico);}
		
		//Criando Grupos
		Grupo grupoA = new Grupo(1, "A", selecoes1, "HOLANDA", "EQUADOR", "SENEGAL", "CATAR");
		grupoDao.CreateGrup(grupoA);
		
		Grupo grupoB = new Grupo(2, "B", selecoes2, "INGLATERRA","IRA","ESTADOS UNIDOS","GALES");
		grupoDao.CreateGrup(grupoB);
		
		Grupo grupoC = new Grupo(3, "C", selecoes3, "POLONIA", "ARGENTINA", "ARABIA SAUDITA","MEXICO");
		grupoDao.CreateGrup(grupoC);
		
		Grupo grupoD = new Grupo(4, "D", selecoes4, "FRANÇA", "DINAMARCA", "TUNISIA", "AUSTRALIA");
		grupoDao.CreateGrup(grupoD);
		
		Grupo grupoE = new Grupo(5, "E", selecoes5,  "ESPANHA", "JAPAO", "COSTA RICA", "ALEMANHA");
		grupoDao.CreateGrup(grupoE);
		
		Grupo grupoF = new Grupo(6, "F", selecoes6, "CROACIA", "MARROCOS","BELGICA", "CANADA");
		grupoDao.CreateGrup(grupoF);
		
		Grupo grupoG = new Grupo(7, "G", selecoes7,"BRASIL", "SUIÇA", "CAMAROES", "SERVIA");
		grupoDao.CreateGrup(grupoG);
		
		Grupo grupoH = new Grupo(8, "H", selecoes8, "URUGUAI", "PORTUGAL", "COREIA DO SUL",  "GANA");
		grupoDao.CreateGrup(grupoH);
	
			
	}
	
	public static void PartidasFaseGrupos(){
		SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
		ArbitroDaoImpl arbitroDao = new ArbitroDaoImpl();
		GrupoDaoImpl grupoDao = new GrupoDaoImpl();
		FaseGruposDaoImpl faseGruposDao = new FaseGruposDaoImpl();
		ArrayList<Selecao> carregarSelecao = selecaoDao.ListSelecao();
		
		String horario;
		int dia=1, mes=11;
		// Se os 8 grupos estiverem formados 
			if(grupoDao.ListGrup().size()==8) {
				// So sera possivel criar as partidas automaticas, se a lista de partidas estiver vazia
				if(faseGruposDao.ListPart().size()==0) {
					//Buscando todos os grupos
					for (Grupo grupo : grupoDao.ListGrup()) {
						//Buscando o id da primeira selecao dentro do grupo
						for(int k=0; k<grupo.getSelecoes().size();k++) {
							//id da selecao1
							int idSelecao1=grupo.getSelecoes().get(k);
							//Buscando o id da segunda selecao dentro do grupo
							for(int p=k+1; p<grupo.getSelecoes().size();p++) {
								//id da selecao2
								int idSelecao2=grupo.getSelecoes().get(p);
								//Cria a partida com dados vazios, somente com os dados dados da selecao
								String data = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+"2022";
								if(dia%2==0) {
									horario = "12:00";}
								
								else {
									horario = "16:00";}
											
								Partida partida = new Partida(faseGruposDao.getUltimoid(),data, horario, "DOHA ",carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getId(), carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getId(), arbitroDao.getUltimoid(),0, 0, "Teste",0,0,0,0, grupo.getId(), true);
								Arbitro Arbitro = new Arbitro(arbitroDao.getUltimoid(), "TESTE", faseGruposDao.getUltimoid());
								// Cria o arbitro no Dao
								arbitroDao.Create(Arbitro);		
			
								if(dia==31) {
									mes++;
									dia=0;
								}
								dia++;
								faseGruposDao.CreatePart(partida);}}}}}
		
			
			faseGruposDao.ListPart().get(0).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(0).setGolsSelecao2(1);
			
			//Holanda 2x0 Senegal
			faseGruposDao.ListPart().get(1).setGolsSelecao1(2);
			
			faseGruposDao.ListPart().get(2).setGolsSelecao1(2);
			
			//Equador/Senegal
			faseGruposDao.ListPart().get(3).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(3).setGolsSelecao2(2);
			
			////Equador x catar
			faseGruposDao.ListPart().get(4).setGolsSelecao1(2);
			
			//Senegal x Catar
			faseGruposDao.ListPart().get(5).setGolsSelecao1(3);
			faseGruposDao.ListPart().get(5).setGolsSelecao2(1);
			
			
			// Inglaterra X Irã
			faseGruposDao.ListPart().get(6).setGolsSelecao1(6);
			faseGruposDao.ListPart().get(6).setGolsSelecao2(2);
			
			
			
			// Inglaterra X Eua 0x0
			
			
			// Inglaterra X gales 0x0
				faseGruposDao.ListPart().get(8).setGolsSelecao1(3);
				faseGruposDao.ListPart().get(8).setGolsSelecao2(0);
				
			//Ira x Eua
				faseGruposDao.ListPart().get(9).setGolsSelecao1(0);
				faseGruposDao.ListPart().get(9).setGolsSelecao2(1);
				
			// irax gales
				faseGruposDao.ListPart().get(10).setGolsSelecao1(2);
				faseGruposDao.ListPart().get(10).setGolsSelecao2(0);
			//Eua x gales
				faseGruposDao.ListPart().get(11).setGolsSelecao1(1);
				faseGruposDao.ListPart().get(11).setGolsSelecao2(1);
			
			// Polonia x argentina	
				faseGruposDao.ListPart().get(12).setGolsSelecao1(0);
				faseGruposDao.ListPart().get(12).setGolsSelecao2(2);	
				
			// Polonia x Arabia
			faseGruposDao.ListPart().get(13).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(13).setGolsSelecao2(0);		
			
			// Polonia x mexico 0x0
			
			
			//Argentina X arabia
			faseGruposDao.ListPart().get(15).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(15).setGolsSelecao2(2);	
			
			//Argentina X Mexico
			faseGruposDao.ListPart().get(16).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(16).setGolsSelecao2(0);	
			
			//Arabia x Mexico
			faseGruposDao.ListPart().get(17).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(17).setGolsSelecao2(2);
			
			//França X Dinarmarca
			faseGruposDao.ListPart().get(18).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(18).setGolsSelecao2(1);
			
			//França X Tunisia
			faseGruposDao.ListPart().get(19).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(19).setGolsSelecao2(1);
			
			//França X Australia
			faseGruposDao.ListPart().get(20).setGolsSelecao1(4);
			faseGruposDao.ListPart().get(20).setGolsSelecao2(1);
			
			// Dinamarca x Tunisia 0x0
			
			// Dinamarca x Australia
			faseGruposDao.ListPart().get(22).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(22).setGolsSelecao2(1);
		
			//Tunisia x Australia
			faseGruposDao.ListPart().get(23).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(23).setGolsSelecao2(1);
			
			// Espanha x Japão
			faseGruposDao.ListPart().get(24).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(24).setGolsSelecao2(2);
			
			// Espanha x Costa Rica
			faseGruposDao.ListPart().get(25).setGolsSelecao1(7);
			faseGruposDao.ListPart().get(25).setGolsSelecao2(0);
			
			// Espanha x Alemanha
			faseGruposDao.ListPart().get(26).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(26).setGolsSelecao2(1);
			
			
			// Japão x Costa Rica
			faseGruposDao.ListPart().get(27).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(27).setGolsSelecao2(1);
			
			// Japão x Alemanha
			faseGruposDao.ListPart().get(28).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(28).setGolsSelecao2(1);
			
			// Costa Rica x Alemanha
			faseGruposDao.ListPart().get(29).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(29).setGolsSelecao2(4);
			
			// Croacia x canada
			faseGruposDao.ListPart().get(32).setGolsSelecao1(4);
			faseGruposDao.ListPart().get(32).setGolsSelecao2(1);
			
			// Marrocos x belgica
			faseGruposDao.ListPart().get(33).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(33).setGolsSelecao2(0);
			
			// Marrocos x canada
			faseGruposDao.ListPart().get(34).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(34).setGolsSelecao2(1);
			
			// Belgica x canada
			faseGruposDao.ListPart().get(35).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(35).setGolsSelecao2(0);
			
			
			// Brasil x Suiça
			faseGruposDao.ListPart().get(36).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(36).setGolsSelecao2(0);
			
			// Brasil x Camaroes
			faseGruposDao.ListPart().get(37).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(37).setGolsSelecao2(1);
			
			// Brasil x Servia
			faseGruposDao.ListPart().get(38).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(38).setGolsSelecao2(0);
			
			// Suiça x camaroes
			faseGruposDao.ListPart().get(39).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(39).setGolsSelecao2(0);		
			
			// Suiça x Servia
			faseGruposDao.ListPart().get(40).setGolsSelecao1(3);
			faseGruposDao.ListPart().get(40).setGolsSelecao2(2);			
			
			// Camaroes x Servia
			faseGruposDao.ListPart().get(41).setGolsSelecao1(3);
			faseGruposDao.ListPart().get(41).setGolsSelecao2(3);	
			
			// Uruguai x Portugal
			faseGruposDao.ListPart().get(42).setGolsSelecao1(0);
			faseGruposDao.ListPart().get(42).setGolsSelecao2(2);
			
			// Uruguai x Coreia do Sul 0x0
					
			
			// Uruguai x Gana
			faseGruposDao.ListPart().get(44).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(44).setGolsSelecao2(0);			
			
			
			// Portugal x Coreia do Sul
			faseGruposDao.ListPart().get(45).setGolsSelecao1(1);
			faseGruposDao.ListPart().get(45).setGolsSelecao2(2);	
			
			// Portugal x Gana
			faseGruposDao.ListPart().get(46).setGolsSelecao1(3);
			faseGruposDao.ListPart().get(46).setGolsSelecao2(2);				
			
			//Coreia do Sul x Gana 
			faseGruposDao.ListPart().get(47).setGolsSelecao1(2);
			faseGruposDao.ListPart().get(47).setGolsSelecao2(3);
			
			
			
			for(Partida partida : faseGruposDao.ListPart()) {
				int golsSelecao1 = partida.getGolsSelecao1();
				int golsSelecao2 = partida.getGolsSelecao2();
				
						
				//Adicionando pontuacao de vitoria da selecao 1 e cartoes aleatorios na partida
				if(golsSelecao1>golsSelecao2) {
					int idSelecao=partida.getSelecao1();
					int indexSelecao = Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), idSelecao);
					Selecao selecao =selecaoDao.ListSelecao().get(indexSelecao);
					Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
							selecao.getIdGrupo(), selecao.getPontuacao()+3, selecao.getSaldoGols(), selecao.getTotalCartoes()+2);
					selecaoDao.UpdateSelecao(Novaselecao, idSelecao);}
				
				//Adicionando pontuacao vitoria da selecao 2
				if(golsSelecao2>golsSelecao1) {
					int idSelecao=partida.getSelecao2();
					int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
					Selecao selecao =carregarSelecao.get(indexSelecao);
					Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
							selecao.getIdGrupo(), selecao.getPontuacao()+3, selecao.getSaldoGols(), selecao.getTotalCartoes()+1);
							selecaoDao.UpdateSelecao(Novaselecao, idSelecao);}
				
				
				//Adicionando pontuacao de empate
				if(golsSelecao2==golsSelecao1) {
					int idSelecao=partida.getSelecao1();
					int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
					Selecao selecao =carregarSelecao.get(indexSelecao);
					Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
							selecao.getIdGrupo(),selecao.getPontuacao() +1, selecao.getSaldoGols(), selecao.getTotalCartoes()+1);
					selecaoDao.UpdateSelecao(Novaselecao, idSelecao);
										
					int idSelecao2=partida.getSelecao2();
					int indexSelecao2 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao2);
					Selecao Selecao2 =selecaoDao.ListSelecao().get(indexSelecao2);
					Selecao Novaselecao2 = new Selecao(idSelecao2,Selecao2.getNome() ,Selecao2.getTime(),Selecao2.getTecnico(),
							Selecao2.getIdGrupo(), Selecao2.getPontuacao()+1, Selecao2.getSaldoGols(), selecao.getTotalCartoes());
					selecaoDao.UpdateSelecao(Novaselecao2, idSelecao2);}
				
				int idSelecao=partida.getSelecao1();
				int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
				int SaldoAnt1 = selecaoDao.ListSelecao().get(indexSelecao).getSaldoGols();
				selecaoDao.ListSelecao().get(indexSelecao).setSaldoGols(SaldoAnt1-golsSelecao2+golsSelecao1);
				
				int idSelecao2=partida.getSelecao2();
				int indexSelecao2 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao2);
				int SaldoAnt2 = selecaoDao.ListSelecao().get(indexSelecao2).getSaldoGols();
				selecaoDao.ListSelecao().get(indexSelecao2).setSaldoGols(SaldoAnt2+golsSelecao2-golsSelecao1);
				
			
		
		
		
		
		
	}}}

	
	
	
	
		
		
		
	
