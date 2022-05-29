'use strict';

const menu_btn = document.getElementById('menu-btn');
const menu = document.getElementById('menu');
menu_btn.onclick = function() {
	if (menu.className === 'no-disp') {
		menu.className = 'disp';
		menu_btn.textContent = "閉じる";
	} else {
		menu.className = 'no-disp';
		menu_btn.textContent = 'メニュー';
	}
	// menu.classList.toggle('no-disp');
}
