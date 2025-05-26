console.log("Welcome to the Community Portal");
window.onload = () => alert("Page fully loaded!");
const eventName = "Spring Festival";
const eventDate = "2025-05-25";
let availableSeats = 50;
console.log(`Event: ${eventName} on ${eventDate} | Seats: ${availableSeats}`);
const events = [
  { name: "Spring Festival", date: "2025-05-25", seats: 50 },
  { name: "Clean-Up Drive", date: "2025-06-03", seats: 0 },
  { name: "Food Drive", date: "2025-06-10", seats: 30 }
];
events.forEach(event => {
  if (new Date(event.date) > new Date() && event.seats > 0) {
    console.log(`Upcoming: ${event.name} (${event.date}) - ${event.seats} seats`);
  }
});
function addEvent(name, date, seats) {
  events.push({ name, date, seats });
}
function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  if (event && event.seats > 0) {
    event.seats--;
    console.log(`Registered for ${eventName}. Seats left: ${event.seats}`);
  } else {
    console.warn("Event full or not found.");
  }
}
const categoryCount = (() => {
  let total = 0;
  return () => ++total;
})();
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0 ? "Available" : "Full";
};
const fest = new Event("Yoga Camp", "2025-07-01", 20);
console.log(Object.entries(fest));
events.push({ name: "Music Night", date: "2025-08-01", seats: 40 });
const musicEvents = events.filter(e => e.name.includes("Music"));
const displayNames = events.map(e => `Event: ${e.name}`);
console.log(displayNames);
document.querySelectorAll(".event-img").forEach(img => {
  img.addEventListener("click", () => alert("You clicked an event image!"));
});
function validatePhone() {
  const phone = document.getElementById("phone").value;
  if (!/^\d{10}$/.test(phone)) alert("Enter a valid 10-digit phone number.");
}
function showFee() {
  const fees = { festival: "$10", cleanup: "Free", donation: "$5" };
  const selected = document.getElementById("eventType").value;
  document.getElementById("feeOutput").textContent = "Fee: " + (fees[selected] || "");
  localStorage.setItem("preferredEvent", selected);
}
function enlargeImage(img) {
  img.style.width = img.style.width === "400px" ? "200px" : "400px";
}
function countChars(el) {
  document.getElementById("charCount").textContent = "Characters: " + el.value.length;
}
function warnUser() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  return name || email ? "You have unsaved changes!" : undefined;
}
function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared.");
}
function findLocation() {
  if (!navigator.geolocation) {
    document.getElementById("locationOutput").textContent = "Geolocation not supported.";
    return;
  }
  navigator.geolocation.getCurrentPosition(
    (pos) => {
      const { latitude, longitude } = pos.coords;
      document.getElementById("locationOutput").textContent = `Latitude: ${latitude}, Longitude: ${longitude}`;
    },
    () => {
      document.getElementById("locationOutput").textContent = "Permission denied or timeout.";
    },
    { enableHighAccuracy: true, timeout: 10000 }
  );
}
async function fetchEvents() {
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts/1");
    const data = await res.json();
    console.log("Fetched event data:", data);
  } catch (err) {
    console.error("Failed to fetch events:", err);
  }
}
const cloneEvents = [...events];
const [{ name: firstName }] = events;
console.log(`First Event Name: ${firstName}`);
document.querySelector("form").addEventListener("submit", function (e) {
  e.preventDefault();
  const formData = new FormData(e.target);
  console.log("Form submitted:", Object.fromEntries(formData.entries()));
});
function submitToServer(data) {
  console.log("Sending data...", data);
  setTimeout(() => {
    console.log("Registration successful!");
    alert("Server received your registration!");
  }, 1500);
}
