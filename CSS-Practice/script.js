console.log("Dashboard Project Started!");
const sidebar = document.querySelector(".sidebar");
const toggleBtn = document.querySelector("#sidebarToggle");

toggleBtn.addEventListener("click", () => {
  sidebar.classList.toggle("open");
});
