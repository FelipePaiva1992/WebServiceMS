
/**
 * @author Felipe
 * Esta funcao ajax busca uma lista de venda pendentes que precisam ser entregues
 * e passa cada venda para o metodo "adicionarVenda(venda)"
 */
function ajaxVendasPendentes(){
	$.ajax({
        type:"GET",
		url : "rest/endpointVenda/obterUltimasVendas",
        dataType: "json",                
		success : function(dataResult) {
			
			$('#painelvendas').html("").trigger("create");
			for(var i=0; i < dataResult.length; i ++){
				adicionarVenda(dataResult[i].idVenda, dataResult[i].vendaItems);
			}
				
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus + "\n" + errorThrown);
		},
		beforeSend: function(){			
			//$.mobile.loading('show');
		},
		complete: function(){
			//$.mobile.loading('hide');
		}
	});
}


function ajaxEntregarVenda(idCampoVenda, idVenda){
	$.ajax({
        type:"GET",
		url : "rest/endpointVenda/entregarVenda?idVenda=" + idVenda,
        dataType: "json",                
		success : function(dataResult) {
			
			alert("Venda Entregue");
			$("#" + idCampoVenda).hide();
				
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao dar baixa na venda!");
			console.log(textStatus + "\n" + errorThrown);
		},
		beforeSend: function(){	
			//$.mobile.loading('show');
		},
		complete: function(){
			//$.mobile.loading('hide');
		}
	});
}

function ajaxLogar(){
	var nmUsuario = $('#nmUsuario').val();
	var vlSenha =  $('#vlSenha').val();
	$.ajax({
        type:"POST",
		url : "rest/endpointAcesso/consultaUsuarioSenha",
		data: {"nmUsuario":nmUsuario,"vlSenha":vlSenha},
        dataType: "json",                
		success : function(dataResult) {
			
			switch (dataResult.perfilAcesso.nmPerfilAcesso) {
			case "ADMINISTRADOR":
				window.location = "interno/cadastro.html";
				break;
			case "OPERACIONAL":
				window.location = "interno/venda.html";
				break;
			case "VENDEDOR":
				alert("Erro ao efetuar Login!");
				break;
			}
				
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao efetuar Login!");
			console.log(textStatus + "\n" + errorThrown);
		},
		beforeSend: function(){	
			//$.mobile.loading('show');
		},
		complete: function(){
			//$.mobile.loading('hide');
		}
	});
}

function ajaxCadastraUsuario(){
	var nmVendedor =  $('#cadNmVendedor').val();
	var vlSenha =  $('#cadVlSenha').val();
	var perfilAcesso = $('#cadPerfilAcesso').val();
	var url;
	var data;
	if(perfilAcesso == 3){
		url = "../rest/endpointVendedor/cadastrarVendedor";
		data = {"nmVendedor":nmVendedor,"vlSenha":vlSenha};
	}else{
		var idVendedor = $('#cadIdVendedor').val();
		url = "../rest/endpointAcesso/criarUsuarioSistema";
		data = {"usUsuario":idVendedor,"nmUsuario":nmVendedor,"vlSenha":vlSenha,"idPerfil":perfilAcesso}
	}
	$.ajax({
        type:"POST",
		url : url,
		data: data,
        dataType: "json",                
		success : function(dataResult) {
			
			if(perfilAcesso == 3){
				alert("Vendedor cadastrado com sucesso! Codigo Vendedor: " + dataResult.idVendedor);				
			}else{
				alert("Usuario cadastrado com sucesso!");	
			}
				
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus + "\n" + errorThrown);
		},
		beforeSend: function(){			
			//$.mobile.loading('show');
		},
		complete: function(){
			//$.mobile.loading('hide');
		}
	});
}
