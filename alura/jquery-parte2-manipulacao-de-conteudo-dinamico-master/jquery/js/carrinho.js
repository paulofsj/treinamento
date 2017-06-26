$(function(){
	recarrega();
	for(var i = 0; i < 10; i++) {
    setTimeout(function() {
        console.log(i);
    }, 1000);
}
});

function recarrega(){
	//carregaValorTotal();
	//carregaTotalItens();
};

function carregaValorTotal(){
	var valorTotal = 0;
	$(".item-total:visible").each(function(){
		var vaolorTotalItem = parseFloat($(this).text());
		valorTotal += vaolorTotalItem;
	});
	$("#valor-total").text(valorTotal);
};



$(".delete").click(function(event){
	event.preventDefault();
    var linha = $(this).closest("tr");

    linha.fadeOut(500);
    setTimeout(function() {
    	linha.hide();
        recarrega();
    }, 600);
    
});

$("#botao-undo").click(function(){
	$("tr:visible").removeClass("recuperado");
    
    var trs = $("tr:hidden");
    trs.addClass("recuperado");
    trs.show();

    recarrega();
});