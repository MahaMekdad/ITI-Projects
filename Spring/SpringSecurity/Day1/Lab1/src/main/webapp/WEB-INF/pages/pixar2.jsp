<!DOCTYPE html>
<head>
    <title>Pixar Simple Webpage</title>
    <link id="theme" rel="stylesheet" href="style.css"/>
    <script>
        function changeTheme(){
            var theme = document.getElementsByTagName('link')[0];
            if(theme.getAttribute('href') == 'style.css'){
                theme.setAttribute('href', 'styleDark.css');
                //document.body.style.backgroundColor= "LightBlue";
                // document.body.textContent.fontcolor= "black";
            } else{
                theme.setAttribute("href", "style.css");
                // document.body.style.backgroundColor= "LightYellow";
                // document.body.textContent.fontcolor.apply= "white";
                // document.body.fontcolor="white";
                // document.fontcolor="white";
                // document.body.innerText.fontcolor="Red";
            }
        }
    </script>
</head>
<body>
    <header>
        <div id="container">
            <nav>
                <ul>
                    <li><a href="#about">About</a></li>
                    <li><a href="#movies">Movies</a></li>
                    <li><button type="button" onclick="changeTheme()">Dark Theme</button></li>
                </ul>
            </nav>
        </div>
        <div>
            <h1>PIXAR</h1>
            <img src="pixar.jpg">
        </div>
    </header>
    <main>
        <section id="about">
            <div>
                <h1 id="hpTitle">History of Pixar</h1><br>
                <p><img id="pixarHistory" src="pixarImgComputer.jpg" alt="A Pixar computer at the Computer History Museum in Mountain View" width="90" height="90">
                    some sentences here about the history of pixar ... keep on imagining .. yep good.
                    Here are some that i've just copied cus i don't have enough time to tell you the whole story
                    Pixar began in 1979 as part of the Lucasfilm computer division, known as the Graphics Group, before its spin-off
                    as a corporation in 1986, with funding from Apple co-founder Steve Jobs, who became its majority shareholder.
                    But now try to imagine a document with 30 or 40 H1s. Based on the properties in this example, all of the H1s would 
                    automatically be red, without having to add any additional code in the HTML. If I wanted to change them to blue, 
                    all I’d have to do is change the CSS, as opposed to individually going through 40 H1s in the document.....
                    some sentences here about the history of pixar ... keep on imagining .. yep good.
                    Here are some that i've just copied cus i don't have enough time to tell you the whole story
                    Pixar began in 1979 as part of the Lucasfilm computer division, known as the Graphics Group, before its spin-off
                    as a corporation in 1986, with funding from Apple co-founder Steve Jobs, who became its majority shareholder.
                    But now try to imagine a document with 30 or 40 H1s. Based on the properties in this example, all of the H1s would 
                    automatically be red, without having to add any additional code in the HTML. If I wanted to change them to blue, 
                    all I’d have to do is change the CSS, as opposed to individually going through 40 H1s in the document.
                    some sentences here about the history of pixar ... keep on imagining .. yep good.
                    Here are some that i've just copied cus i don't have enough time to tell you the whole story
                    Pixar began in 1979 as part of the Lucasfilm computer division, known as the Graphics Group, before its spin-off
                    as a corporation in 1986, with funding from Apple co-founder Steve Jobs, who became its majority shareholder.
                    But now try to imagine a document with 30 or 40 H1s. Based on the properties in this example, all of the H1s would 
                    automatically be red, without having to add any additional code in the HTML. If I wanted to change them to blue, 
                    all I’d have to do is change the CSS, as opposed to individually going through 40 H1s in the document.....
                    some sentences here about the history of pixar ... keep on imagining .. yep good.
                    Here are some that i've just copied cus i don't have enough time to tell you the whole story
                    Pixar began in 1979 as part of the Lucasfilm computer division, known as the Graphics Group, before its spin-off
                    as a corporation in 1986, with funding from Apple co-founder Steve Jobs, who became its majority shareholder.
                    But now try to imagine a document with 30 or 40 H1s. Based on the properties in this example, all of the H1s would 
                    automatically be red, without having to add any additional code in the HTML. If I wanted to change them to blue, 
                    all I’d have to do is change the CSS, as opposed to individually going through 40 H1s in the document.
                </p>
            </div>
        </section>
        <section id="movies">
            <h1>Movies</h1>
            <h3>My Favorite Movies:</h3>
            <table class="center">
                <tr>
                    <td><img src="ratatouille.jpg" width="500" height="750"></td>
                    <td><img src="up.jpg" width="500" height="750"></td>
                    <td><img src="toyStory.jfif" width="500" height="750"></td>
                </tr>
                <tr>
                    <td><img src="theGoodDinosaur.jfif" width="500" height="750"></td>
                    <td><img src="insideOut.jpg" width="500" height="750"></td>
                    <td><img src="soul.jpg" width="500" height="750"></td>
                </tr>
            </table>
        </section>
    </main>
    <footer>
        © Copyright Mahameho, 2021
    </footer>
</body>