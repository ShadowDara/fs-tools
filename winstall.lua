-- Install Script for Windows
-- FS-Tools
-- Requires Luajit 0.1.8
-- https://github.com/ShadowDara/LuaAPI-Rust

local dapi = require("dapi")
local dapi_os = require("dapi_os")
local dapi_io = require("dapi_io")

print("FS-Tools Install Script for Windows")

dapi.download("https://raw.githubusercontent.com/ShadowDara/dotfiles/refs/heads/main/install-scripts/search_java.ps1", "search_java.ps1")

local result = dapi_os.run("./search_java.ps1 21")
print("Exit code:", result.status)
print("STDOUT:", result.stdout)
print("STDERR:", result.stderr)

dapi_io.create_file("JAVA_21.cmd")

local lines = dapi_io.read_line("java.21.txt.dumb", 1)

for i, line in ipairs(lines) do
    dapi_io.write_file("JAVA_21.cmd", line)
end

dapi_io.create_file("fs.cmd")
dapi_io.write_file("fs.cmd", "JAVA_21 -jar fs-tools.jar")
