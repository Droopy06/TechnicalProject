/**
* Created by LAMOOT Alexandre on 28/04/2016.
*/

var body = $('body');
/***
 * Sameheight initializer
 */
equalheight('.sameHeight');
/***
 * Magic Height initializer
 */
magicHeight();
/***
 * Gives two column the same height
 */
function equalheight(container) {
    var currentTallest = 0;
    var currentRowStart = 0;
    var rowDivs = new Array();
    var $el;
    var topPosition = 0;

    $(container).each(function () {
        $el = $(this);
        $($el).height('auto')
        topPosition = $el.position().top;

        if (currentRowStart != topPosition) {
            for (currentDiv = 0; currentDiv < rowDivs.length; currentDiv++) {
                rowDivs[currentDiv].height(currentTallest);
            }

            rowDivs.length = 0; // empty the array
            currentRowStart = topPosition;
            currentTallest = $el.height();
            rowDivs.push($el);
        } else {
            rowDivs.push($el);
            currentTallest = (currentTallest < $el.height()) ? ($el.height()) : (currentTallest);
        }

        for (currentDiv = 0; currentDiv < rowDivs.length; currentDiv++) {
            rowDivs[currentDiv].height(currentTallest);
        }
    });
}
function magicHeight() {
    if (body.hasClass('home') || body.hasClass('single-carnet') || body.hasClass('sign-in')) {
        $('#main').css({
            'height': $(window).height()
        });
    }
}

$(window).on('resize', function () {
    equalheight('.sameHeight');
    magicHeight();
});