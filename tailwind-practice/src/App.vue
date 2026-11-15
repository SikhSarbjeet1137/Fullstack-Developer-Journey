<script setup>
import { ref } from "vue";

// Store tasks
const tasks = ref([]);

// Input field
const newTask = ref("");

// Hide / Show task list
const showTasks = ref(true);

// Add Task
const addTask = () => {
  if (newTask.value.trim() !== "") {
    tasks.value.push({
      id: crypto.randomUUID(),
      name: newTask.value.trim(),
      completed: false,
    });

    newTask.value = "";
  }
};

// Remove Task
const removeTask = (id) => {
  tasks.value = tasks.value.filter((task) => task.id !== id);
};

// Mark Task Completed
const toggleComplete = (id) => {
  const task = tasks.value.find((task) => task.id === id);

  if (task) {
    task.completed = !task.completed;
  }
};

// Completed Task Count
const completedCount = () => {
  return tasks.value.filter((task) => task.completed).length;
};
</script>

<template>
  <div
    class="min-h-screen bg-black text-white flex justify-center items-center p-5"
  >
    <div
      class="bg-gray-900 w-full max-w-lg p-6 rounded-xl border border-yellow-400"
    >
      <!-- Heading -->
      <h1 class="text-3xl font-bold text-yellow-400 text-center mb-6">
        Task Management App
      </h1>

      <!-- Input Section -->
      <div class="flex gap-2 mb-6">
        <input
          type="text"
          v-model="newTask"
          @keyup.enter="addTask"
          placeholder="Enter your task"
          class="flex-1 p-3 rounded-lg bg-gray-800 border border-gray-600 text-white outline-none focus:border-yellow-400"
        />

        <button
          @click="addTask"
          class="bg-yellow-400 text-black px-4 rounded-lg font-bold hover:bg-yellow-300"
        >
          Add
        </button>
      </div>

      <!-- Statistics -->
      <div class="grid grid-cols-2 gap-4 mb-5">
        <div class="bg-gray-800 p-4 rounded-lg text-center">
          <p class="text-gray-400">Total Tasks</p>
          <h2 class="text-2xl font-bold text-yellow-400">
            {{ tasks.length }}
          </h2>
        </div>

        <div class="bg-gray-800 p-4 rounded-lg text-center">
          <p class="text-gray-400">Completed</p>
          <h2 class="text-2xl font-bold text-green-400">
            {{ completedCount() }}
          </h2>
        </div>
      </div>

      <!-- Hide / Show Button -->
      <button
        @click="showTasks = !showTasks"
        class="w-full bg-yellow-400 text-black p-3 rounded-lg font-bold mb-5 hover:bg-yellow-300 transition"
      >
        {{ showTasks ? "Hide Tasks" : "Show Tasks" }}
      </button>

      <!-- Task List -->
      <div v-if="showTasks">
        <!-- Empty Message -->
        <div v-if="tasks.length === 0" class="text-center text-gray-400 py-5">
          No tasks available
        </div>

        <!-- Display Tasks -->
        <div
          v-for="task in tasks"
          :key="task.id"
          class="flex justify-between items-center bg-gray-800 p-4 rounded-lg mb-3 gap-3"
        >
          <div class="flex-1">
            <span
              :class="
                task.completed ? 'line-through text-gray-500' : 'text-white'
              "
            >
              {{ task.name }}
            </span>

            <p v-if="task.completed" class="text-green-400 text-xs mt-1">
              Completed
            </p>
          </div>

          <div class="flex gap-2">
            <!-- Complete Button -->
            <button
              @click="toggleComplete(task.id)"
              class="bg-green-600 text-white px-3 py-2 rounded-lg text-sm hover:bg-green-700"
            >
              {{ task.completed ? "Undo" : "Done" }}
            </button>

            <!-- Delete Button -->
            <button
              @click="removeTask(task.id)"
              class="bg-red-500 text-white px-3 py-2 rounded-lg text-sm hover:bg-red-600"
            >
              Delete
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
