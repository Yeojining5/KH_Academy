
//////////////// 스크롤 스파이 이벤트 ///////////////////
$(function(){

    const link = $('#sidebar a.dot');
    link.on('click',function(e){
        //href 속성을 통해, section id 타겟을 잡음
        const target = $($(this).attr('href')); 

        //target section의 좌표를 통해 꼭대기로 이동
        $('html, body').animate({
            scrollTop: target.offset().top
            },700);

        //active 클래스 부여
        $(this).addClass('active');

        //앵커를 통해 이동할때, URL에 #id가 붙지 않도록 함.
        e.preventDefault();
    });

    $(window).on('scroll',function(){
        findPosition();
        });

    function findPosition(){
        $('section').each(function(){
            if( ($(this).offset().top - $(window).scrollTop() ) < 20){
                link.removeClass('active');
                $('#sidebar').find('[data-scroll="'+ $(this).attr('id') +'"]').addClass('active');
                }
            });
        }

    findPosition();
});

/////////////////////////////////////////////////

///////////////// 센터 소개 옵션 객체 ////////////

const hour_week = '평 일 : 06:00 ~ 24:00';
const hour_weekend = '토-일, 공휴일 : 06:00 ~ 22:00 (연중무휴)';
const parking = '주차장 3시간 무료';

function Option(name, address, tell) {
    this.name = name;
    this.address = address;
    this.tell = tell;
}

const option1 = new Option(
    '강남 센터',
    '서울 강남구 테헤란로14길 6 남도빌딩',
    '02-1234-1234'
);
const option2 = new Option(
    '종로 센터',
    '서울 종로구 종로1길 36 대림빌딩',
    '02-2345-2345'
);
const option3 = new Option(
    '마포 센터',
    '서울 마포구 월드컵로 212',
    '02-3456-3456'
);
const option4 = new Option(
    '서초 센터',
    '서울 서초구 남부순환로 2584',
    '02-4567-4567'
);
const option5 = new Option(
    '영등포 센터',
    '서울 영등포구 당산로 123',
    '02-5678-5678'
);


////////////////////////////////////////////////


///////////////// 센터 소개 콤보박스 ////////////////
const cmbbox = document.querySelector('#select_value'); // <select>

const items = document.querySelector('.items'); // <ul>


function getValue() {
    alert(cmbbox.options[cmbbox.selectedIndex].value
        + cmbbox.options[cmbbox.selectedIndex].text);
    document.querySelector('.items').innerHTML = selectedIndex;
}


function addItem() {
    const text = "IntelliGym "+ cmbbox.options[cmbbox.selectedIndex].text;

    const item = createItem(text);
    items.appendChild(item);
}


function createItem(text) {
    const itemRow = document.createElement('li');
    itemRow.setAttribute('class','item_row');

    const item = document.createElement('div');
    item.setAttribute('class','item');

    const item_name = document.createElement('span');
    item_name.setAttribute('class','item_name');
    // innerHTML, innerText, textContent 모두 같은 기능
    item_name.innerText = text; 
    
    const item_con = document.createElement('p');
    item_con.setAttribute('class', 'item_con');

    // 주소 안내
    const index_ad = document.createElement('li');
    index_ad.setAttribute('class', 'index_ad');
    index_ad.innerHTML = '주소';
    // 들어갈 주소
    const item_address = document.createElement('p');
    item_address.setAttribute('class', 'item_address');

    // 전화번호 안내
    const index_t = document.createElement('li');
    index_t.setAttribute('class', 'index_t');
    index_t.innerHTML = '전화번호';
    // 들어갈 전화번호
    const item_tell = document.createElement('p');
    item_tell.setAttribute('class', 'item_tell');

    // 운영시간 안내
    const index_time = document.createElement('li');
    index_time.setAttribute('class', 'index_time');
    index_time.innerHTML = '운영시간';
    // 들어갈 운영시간
    const item_hour_week = document.createElement('p'); /// 평일
    item_hour_week.setAttribute('class','item_hour_week');
    item_hour_week.innerHTML = hour_week;
    const item_hour_weekend = document.createElement('p'); /// 주말
    item_hour_weekend.setAttribute('class','item_hour_weekend');
    item_hour_weekend.innerHTML = hour_weekend;

    // 무료주차 안내
    const index_parking = document.createElement('li');
    index_parking.setAttribute('class', 'index_parking');
    index_parking.innerHTML = '운영시간';
    // 들어갈 무료주차 안내
    const item_parking = document.createElement('lp');
    item_parking.setAttribute('class','item_parking');
    item_parking.innerHTML = parking;


    // 콤보박스 옵션 선택 시 다른 조건으로 출력
    const selectedIndex = cmbbox.options[cmbbox.selectedIndex].text;

    if (selectedIndex == option1.name) {
        item_con.innerHTML = '인텔리짐 강남 센터는 대한민국 휘트니스 대표 브랜드로 강남구 최대규모의 고품격 Total Fitness입니다. 최고의 시설과 최첨단 장비, 전문강사진으로 이루어져 있으며 동종업계 최초로 스포츠 메디컬 케어 시스템을 갖추고 있어 체계적인 건강관리와 최상의 서비스를 제공합니다.';
        item_address.innerHTML = option1.address;
        item_tell.innerHTML = option1.tell;
    } else if (selectedIndex == option2.name) {
        item_con.innerHTML = '인텔리짐 종로 센터는 대한민국 휘트니스 대표 브랜드로 종로구 최대규모의 고품격 Total Fitness입니다. 최고의 시설과 최첨단 장비, 전문강사진으로 이루어져 있으며 동종업계 최초로 스포츠 메디컬 케어 시스템을 갖추고 있어 체계적인 건강관리와 최상의 서비스를 제공합니다.';
        item_address.innerHTML = option2.address;
        item_tell.innerHTML = option2.tell;

    } else if (selectedIndex == option3.name) {
        item_con.innerHTML = '인텔리짐 마포 센터는 대한민국 휘트니스 대표 브랜드로 마포구 최대규모의 고품격 Total Fitness입니다. 최고의 시설과 최첨단 장비, 전문강사진으로 이루어져 있으며 동종업계 최초로 스포츠 메디컬 케어 시스템을 갖추고 있어 체계적인 건강관리와 최상의 서비스를 제공합니다.';
        item_address.innerHTML = option3.address;
        item_tell.innerHTML = option3.tell;

    } else if (selectedIndex == option4.name) {
        item_con.innerHTML = '인텔리짐 서초 센터는 대한민국 휘트니스 대표 브랜드로 서초구 최대규모의 고품격 Total Fitness입니다. 최고의 시설과 최첨단 장비, 전문강사진으로 이루어져 있으며 동종업계 최초로 스포츠 메디컬 케어 시스템을 갖추고 있어 체계적인 건강관리와 최상의 서비스를 제공합니다.';
        item_address.innerHTML = option4.address;
        item_tell.innerHTML = option4.tell;

    } else {
        item_con.innerHTML = '인텔리짐 영등포 센터는 대한민국 휘트니스 대표 브랜드로 영등포구 최대규모의 고품격 Total Fitness입니다. 최고의 시설과 최첨단 장비, 전문강사진으로 이루어져 있으며 동종업계 최초로 스포츠 메디컬 케어 시스템을 갖추고 있어 체계적인 건강관리와 최상의 서비스를 제공합니다.';
        item_address.innerHTML = option5.address;
        item_tell.innerHTML = option5.tell;

    }
    

    // div에 name 넣기 (센터 이름)
    item.appendChild(item_name);

    // div에 p태그 넣기 (센터 설명)
    item.appendChild(item_con);

    item.appendChild(index_ad);
    item.appendChild(item_address);

    item.appendChild(index_t);
    item.appendChild(item_tell);

    item.appendChild(index_time);
    item.appendChild(item_hour_week);
    item.appendChild(item_hour_weekend);

    item.appendChild(index_parking);
    item.appendChild(item_parking);

    // li 태그에 div넣기 
    itemRow.appendChild(item);

    return itemRow;
}


// 셀렉트 박스에서 아이템 선택했을 때 이벤트
cmbbox.addEventListener('change', () => {
    document.querySelector('.items').innerHTML = "";
    addItem();
    });

/////////////////////////////////////////////////////
