$("document").ready(function() {
    var slideIndex = 1;
    showSlides(slideIndex);
});

function plusSlides(n) {
    var slideIndex = $('.active').index();
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    if(n>=($(".mySlides").length)){
        n=1;
    }else if (n<0) {
        n=(($(".mySlides").length)-1);
    }
    $(".demo").each(function(index,element){
        if(index==(n)){

            $("#caption").text($(element).attr("alt"));
        }
    });
    $(".mySlides").each(function(index,element){
        if(index===(n)){
            $(element).css("display","block").addClass("active");
        }else{
            $(element).css("display","none").removeClass("active");
        }
    });
}
