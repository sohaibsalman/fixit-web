//Animation on scroll
$(function () {
    new WOW().init();
});

//Scroll Ease
$(function () {
    $("a.smooth-scroll").click(function (event) {
        event.preventDefault();

        var sectionID = $(this).attr('href');

        $('html, body').animate(
            {
                scrollTop: $(sectionID).offset().top - 64
            }, 1250, "easeInOutExpo"
        );
    })
});

//SIDEBAR
$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
});
