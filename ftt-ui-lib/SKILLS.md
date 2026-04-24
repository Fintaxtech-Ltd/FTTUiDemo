# SKILLS.md
# Automation Blueprints

## Skill: [Component-Gen]
When asked for a new component (e.g., "Add a primary button"):
1. **Apply Template:**
2. **Automatic Preview:** Always generate both Light and Dark mode previews.
3. **Automatic KDoc:** Add basic documentation for public parameters.

## Skill: [Token-Update]
When adding colors or spacing:
1. Locate `FTTColors.kt` or `FTTSpacing.kt`.
2. Add the value to the `CompositionLocalProvider` system.
3. Update the `FTTTheme` wrapper to include the new token.

## Skill: [Test-Gen]
For any clickable/input component, generate: