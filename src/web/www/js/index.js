const languages = {};

let currentLanguage;
let currentFrame;
let dataFrame;

function registerLanguages()
{
  $.get('/languages/', function (data) {
    const selectors = new DOMParser().parseFromString(data, "text/xml").querySelectorAll('a');

    selectors.forEach(element => {
      if(element.textContent.endsWith('json')){
        registerLanguage(element.textContent.replace('.json', ''));
      }
    });
  })
}

function registerLanguage(languageName)
{
  console.log(`loading language: ${languageName}...`);
  const selector = document.querySelector('.selector_language');

  $.get(`/languages/${languageName}.json`, function(data){

    let html = '<option';

    const name = data['name'] ? data['name'] : languageName;

    languages[name] = data;
    console.log(name+' is loaded !');

    if(data['default']){
      html += ' selected';
      currentLanguage = name;
      console.log('Default language set: '+name);
    }

    html += '>'+name+'</option>';

    if(selector != undefined){
      selector.innerHTML += html;
    }
  });
}

function changeEventHandler(event)
{
  if(event.target.value){
    setLanguage(event.target.value);
  }
}

function setLanguage(language)
{
  if(!languages[language] || currentLanguage == language) return;
  console.log(`New language set: ${language}`);
  currentLanguage = language;
  setFrame(currentFrame);
}

function setFrame(frame)
{
  if(currentFrame == frame)
  {
    loadFrame(dataFrame);
    return;
  }

  const intevalId = setInterval(function (){
    if(currentLanguage != undefined){
      $.get(`/contents/${frame}.json`, function(data){
        dataFrame = data;
        currentFrame = frame;
        loadFrame(data);
      });
      clearInterval(intevalId);
    }
  }, 500);
}

function loadFrame(data)
{

  if(data['sidebar']){
    loadSidebar(data['sidebar']);
  }

  if(data['app']){
    loadApp(data['app']);
  }
}

function loadSidebar(data)
{
  if(!data['type']) return;
  const menu = document.querySelector('.menu');
  if(menu == undefined) return;
  menu.innerHTML = "";
  
  $.get(`/contents/sidebar/${data['type']}.json`, (values) => {
    values.forEach(value => {
      menu.innerHTML += '<a class="sidebar_a'+((value['redirect'] && value['redirect'] == currentFrame) ? ' active' : '')+'" href="'+(value['link'] ? value['link'] : '#')+'"'+(value['redirect'] ? ' onClick="setFrame(\''+value['redirect']+'\')"': '')+'>'+translate(value['name'])+'</a>';
    });
  })
}

function loadApp(data){
  const app = document.querySelector('.app');
  if(app == undefined) return;

  let html = "";
    
  if(data['header']){
    html += loadHeader(data['header']);
  }

  if(data['content']){
    html+= loadContent(data['content']);
  }

  if(data['footer']){
    html += loadFooter(data['footer']);
  }

  app.innerHTML = html;
}

function loadHeader(header){
  let html = '<div class="content_header';
  if(header['color']){
    html+=' '+header['color'];
  }
  html+='">';

  if(header['title']){
    html += '<h1 class="content_header_title">'+translate(header['title'])+'</h1>';
  }

  if(header['subtitle']){
    html += addSubtitle(header['subtitle']);
  }

  if(header['subtitles']){
    header['subtitles'].forEach(subtitle => {
      html += addSubtitle(subtitle)
    });
  }

  if(header['buttons']){
    html += '<div class="btn_list">';
    header['buttons'].forEach(button => {
      if(button['link']){
        html += addButtonLink(button);
      }else{
        html += addButtonRedirect(button);
      }
    });
    html += '</div>'
  }

  return html;
}

function addSubtitle(subtitle){
  return '<p class="content_header_subtitle">'+translate(subtitle)+'</p>';
}

function addButtonLink(button){
  return '<a href="'+button['link']+'" class="btn_a" target="_blank"><div class="btn">'+(button['title'] ? translate(button['title']) : '')+'</div></a>'
}

function addButtonRedirect(button){
  return "";
}

function loadContent(content){
  return "";
}

function loadFooter(footer){
  return "";
}

function translate(content){
  return currentLanguage != undefined && languages[currentLanguage] && languages[currentLanguage][content] ? languages[currentLanguage][content] : content;
}