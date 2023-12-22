
<h2 id="quote" style=""></h2>
<pa id="author" class="float-right" style="color: var(--gray-600);"></pa>

<script>
let p = fetch("https://aftab700.pythonanywhere.com/api")
p.then((response) => response.json()).then((value) => {
    document.getElementById("author").innerHTML = "-" + value["author"];
    document.getElementById("quote").innerHTML = value["quote"];
});
console.log("hello");
</script>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>