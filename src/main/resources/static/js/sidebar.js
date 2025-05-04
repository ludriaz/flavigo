document.addEventListener('DOMContentLoaded', function () {
    var sidebarToggle = document.getElementById('sidebarToggle');
    var sidebar = document.getElementById('sidebar');
    var content = document.getElementById('content');
    var sidebarClose = document.getElementById('sidebarClose');

    if (sidebarToggle) {
        sidebarToggle.addEventListener('click', function () {
            sidebar.classList.toggle('open');
            content.classList.toggle('open');
        });
    }

    if (sidebarClose) {
        sidebarClose.addEventListener('click', function () {
            sidebar.classList.remove('open');
            content.classList.remove('open');
        });
    }

    document.addEventListener('click', function (event) {
        var isClickInsideSidebar = sidebar.contains(event.target);
        var isClickInsideToggle = sidebarToggle.contains(event.target);

        if (sidebar.classList.contains('open') && !isClickInsideSidebar && !isClickInsideToggle) {
            sidebar.classList.remove('open');
            content.classList.remove('open');
        }
    });
});