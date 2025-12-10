// Mobile navigation toggle
const navToggle = document.querySelector(".nav__toggle");
const navLinks = document.querySelector(".nav__links");

if (navToggle && navLinks) {
    navToggle.addEventListener("click", () => {
        navLinks.classList.toggle("show");
        navToggle.classList.toggle("open");
    });

    // Close nav when a link is clicked (on small screens)
    navLinks.addEventListener("click", (e) => {
        if (e.target.classList.contains("nav__link")) {
            navLinks.classList.remove("show");
            navToggle.classList.remove("open");
        }
    });
}

// Simple hamburger animation
if (navToggle) {
    navToggle.addEventListener("click", () => {
        const spans = navToggle.querySelectorAll("span");
        if (navToggle.classList.contains("open")) {
            spans[0].style.transform = "translateY(6px) rotate(45deg)";
            spans[1].style.opacity = "0";
            spans[2].style.transform = "translateY(-6px) rotate(-45deg)";
        } else {
            spans[0].style.transform = "";
            spans[1].style.opacity = "";
            spans[2].style.transform = "";
        }
    });
}

// Highlight active nav link on scroll
const sections = document.querySelectorAll("section[id]");
const navLinkElems = document.querySelectorAll(".nav__link");

function setActiveNav() {
    let currentId = "";

    sections.forEach((section) => {
        const rect = section.getBoundingClientRect();
        const offsetTop = window.scrollY + rect.top;
        const threshold = window.scrollY + window.innerHeight * 0.35;

        if (offsetTop <= threshold) {
            currentId = section.getAttribute("id");
        }
    });

    navLinkElems.forEach((link) => {
        link.classList.remove("active");
        const hrefId = link.getAttribute("href").replace("#", "");
        if (hrefId === currentId) {
            link.classList.add("active");
        }
    });
}

window.addEventListener("scroll", setActiveNav);
window.addEventListener("load", setActiveNav);

// IntersectionObserver to fade in sections
const sectionContents = document.querySelectorAll(".section__content");

if ("IntersectionObserver" in window) {
    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    entry.target.classList.add("visible");
                    observer.unobserve(entry.target);
                }
            });
        },
        { threshold: 0.2 }
    );

    sectionContents.forEach((content) => observer.observe(content));
} else {
    // Fallback if IntersectionObserver not supported
    sectionContents.forEach((content) => content.classList.add("visible"));
}

// Contact form: simple frontend validation + fake submit
const contactForm = document.getElementById("contactForm");
const formStatus = document.getElementById("formStatus");

if (contactForm && formStatus) {
    contactForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const name = contactForm.name.value.trim();
        const email = contactForm.email.value.trim();
        const message = contactForm.message.value.trim();

        if (!name || !email || !message) {
            formStatus.textContent = "Please fill out all fields.";
            formStatus.style.color = "#fca5a5";
            return;
        }

        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            formStatus.textContent = "Please enter a valid email address.";
            formStatus.style.color = "#fca5a5";
            return;
        }

        // Simulated success message
        formStatus.textContent = "Thank you! Your message has been sent (simulated).";
        formStatus.style.color = "#bbf7d0";
        contactForm.reset();

        setTimeout(() => {
            formStatus.textContent = "";
        }, 4000);
    });
}

// Dynamic year in footer
const yearSpan = document.getElementById("year");
if (yearSpan) {
    yearSpan.textContent = new Date().getFullYear();
}
