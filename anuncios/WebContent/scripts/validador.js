/**
 * Validação de Formulário JavaScript
 */

function validar(){
	let nomeAnuncio = formContato.nomeAnuncio.value
	let cliente = formContato.cliente.value
	let dataInicio = formContato.dataInicio.value
	let dataFim = formContato.dataFim.value
	let investimento = formContato.investimento.value
	
	if(nomeAnuncio === ""){
		alert("Preencha o campo Nome do Anúncio")
		formContato.nomeAnuncio.focus()
		return false
	}else if(cliente === ""){
		alert("Preencha o Cliente")
		formContato.cliente.focus()
		return false
	}else if(dataInicio === ""){
		alert("Preencha o campo Data de Inicio")
		formContato.dataInicio.focus()
		return false
	}else if(dataFim === ""){
		alert("Preencha o campo Data de Fim")
		formContato.dataFim.focus()
		return false
	}else if(investimento === ""){
		alert("Preencha o campo Investimento")
		formContato.investimento.focus()
		return false
	}else{
		document.forms["formContato"].submit()
	}
}