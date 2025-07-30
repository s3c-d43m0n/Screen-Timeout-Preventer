# Screen Timeout Preventer

A lightweight Java utility to prevent your computer screen from locking or going to sleep due to inactivity. Ideal for presentations, watching videos, reading, or any situation where you want to keep your system awake without constant user interaction... Or when you need to look "online" at work while you're *definitely being productive*.

> 🛠️ **Originally developed for a friend who wanted to appear online on his office laptop during remote work.**  
> No screens were harmed. No bosses were alerted.

---

## Features

- Prevents screen timeout and lock due to inactivity
- Customizable interval between fake keyboard events
- Simple and minimalist GUI, Start/Stop in seconds
- Cross-platform: Windows, Linux, macOS
- Portable `.jar` file, no installation needed
- Requires only Java 8 or higher (JRE 8+)

---

## Getting Started

### 📥 Download

1. Head over to [Releases](https://github.com/s3c-d43m0n/Screen-Timeout-Preventer/releases/latest).
2. Grab the latest `screen-timeout-preventer-X.Y.jar`.

---

### ▶️ Run

Make sure Java is installed:

```bash
java -version
java -jar screen-timeout-preventer-X.Y.jar
```

## Usage

1. Launch the app, if your OS suports system-tray, then access app from there or else a friendly window will open.
2. Set the **interval in seconds** after which a simulated key press will occur.
    - Example: `30` = 2 times every minute
3. No need to restart, it will auto load the provided timer

> 🕶️ Pro Tip: Combine with coffee and headphones for ultimate “online but chill” mode.

---

## Add to Startup (Stay Online Automatically)

Make the app launch on login so you’re *always online* before your first sip of coffee.


### 🐧 Linux (GNOME / Fedora / Ubuntu)

1. Open **Startup Applications** (or run `gnome-session-properties`).
2. Add a new entry:
    - **Name**: Screen Timeout Preventer
    - **Command**:
      ```bash
      java -jar /path/to/ScreenTimeoutPreventer.jar
      ```
    - **Comment**: Stay awake. Stay online.
3. Save and reboot.

**Or**, create a `.desktop` entry manually:

```bash
mkdir -p ~/.config/autostart
nano ~/.config/autostart/screen-timeout-preventer.desktop
```

Paste this:

```ini
[Desktop Entry]
Type=Application
Name=Screen Timeout Preventer
Exec=java -jar /full/path/to/ScreenTimeoutPreventer.jar
X-GNOME-Autostart-enabled=true
Comment=Stay awake. Stay online. Stay legendary.
```

---

### 🪟 Windows

1. Press `Win + R`, type `shell:startup`, press Enter.
2. Copy a shortcut to the `.jar` into the Startup folder.
3. Edit the shortcut’s **Target** to:
   ```cmd
   java -jar "C:\Path\To\ScreenTimeoutPreventer.jar"
   ```

---

### 🍏 macOS

1. Open **System Settings > Users & Groups > Login Items**.
2. Add your `.jar` file or a shell script that launches it:
   ```bash
   #!/bin/bash
   java -jar /path/to/ScreenTimeoutPreventer.jar
   ```

---

## Disclaimer 📝

This tool is for **educational**, **personal productivity**, and *definitely not for slacking off* purposes.  
Use it responsibly. Respect your organization's IT policies.  
Remember: your boss might not believe that you're really typing every 5 minutes.

---

## System Requirements

- Java Runtime Environment (JRE) 8 or newer
- Supported Operating Systems:
    - ✅ Windows
    - ✅ Linux (X11; limited support on Wayland)
    - ✅ macOS

---

## Author

- **s3c-d43m0n** – [GitHub](https://github.com/s3c-d43m0n)

---

## Contributions

Feel like improving the art of *looking busy*?  
Pull requests, issues, and contributions are welcome!

---

## Final Thought 💻☕️

Whether you’re deep in a video call or “monitoring” from afar, let your screen stay awake, so you can stay *mysteriously online*.
```
