var contadorVendas = 0;

/**
 * @author Felipe
 * Esta funcao chama a funcao de adicionar balao venda a tela
 * @param idVenda
 * @param listaProdutos
 */
function adicionarVenda(idVenda, listaProdutos){
	contadorVendas ++;
	var id= "venda"+ contadorVendas;
	var htmlVenda = "";
		htmlVenda += "<div class='venda' id=" + id + ">";
		htmlVenda += "	<div class='headerVenda'>";
		htmlVenda += "		<table style='width: 100%;height: 100%'>";
		htmlVenda += "			<tr valign='middle'>";
		htmlVenda += "				<td valign='middle' align='center' style='width: 50%;margin: 0px; padding:0px;'>";
		htmlVenda += "					<input class='btn-min-style' type='submit' value='Entregue' data-mini='true' onclick='entregarVenda(\"" + id + "\",\"" + idVenda + "\")'>";
		htmlVenda += "				</td>";
		htmlVenda += "				<td valign='middle' align='center' style='width: 50%;margin: 0px; padding:0px;'>";
		htmlVenda += "					<h3 style='margin:0px'>Venda: " + idVenda + "</h3>";
		htmlVenda += "				</td>";
		htmlVenda += "			</tr>";
		htmlVenda += "		</table>";
		htmlVenda += "	</div>";
		htmlVenda += "	<div class='corpoVenda'>";
		htmlVenda += "		<table class='tabelaVenda'>";
		htmlVenda += "			<thead>";
		htmlVenda += "				<tr>";
		htmlVenda += "					<td>";
		htmlVenda += "						Referencia";
		htmlVenda += "					</td>";
		htmlVenda += "					<td>";
		htmlVenda += "						Quantidade";
		htmlVenda += "					</td>";
		htmlVenda += "				</tr>";
		htmlVenda += "			</thead>";
		htmlVenda += "			<tbody>";
		for(var i=0; i < listaProdutos.length; i++){
			htmlVenda += "				<tr>";
			htmlVenda += "					<td>";
			htmlVenda += listaProdutos[i].produto.idRefProduto;
			htmlVenda += "					</td>";
			htmlVenda += "					<td>";
			htmlVenda += listaProdutos[i].vlQuantidade;
			htmlVenda += "					</td>";
			htmlVenda += "				</tr>";
		}
		htmlVenda += "			</tbody>";
		htmlVenda += "		</table>";
		htmlVenda += "	</div>";
		htmlVenda += "</div>";
		
	$('#painelvendas').append(htmlVenda).trigger("create");
}

/**
 * @author Felipe
 * Esta funcao chama a funcao ajax de entrega de venda
 * @param idCampoVenda
 * @param idVenda
 */
function entregarVenda(idCampoVenda, idVenda){
	ajaxEntregarVenda(idCampoVenda, idVenda);
}

function cadastrarUsuario(){
	ajaxCadastraUsuario();
}
 
function perfilChange(){
	var perfil = $('#cadPerfilAcesso').val();
	var label = $('#nomeOuCodigo');
	var input = $('#inputNomeOuCodigo');
	var avisoLabel = $('#avisoNomeOuCodigo');
	if(perfil == 3){
		var inputaux = "";
		input.html(inputaux).trigger("create");
		label.html("").trigger("create");
	}else{
		var inputaux = "<input type='text' id='cadNmVendedor'></input>";
		input.html(inputaux).trigger("create");
		label.html("Usuario:").trigger("create");
	}
}